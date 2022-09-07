package com.wave;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ZygoteServer {
    public static final String TAG = "ZygoteServer";

    private ServerSocket mServerSocket;
    private Socket socket;


    public class ServerSocketThread extends Thread{
        private Socket socket;
        //构造器
        public ServerSocketThread(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            //	定义连接端口
            try{
                //	等待客户端连接
                String RemoteIP = socket.getInetAddress().getHostAddress();
                //	获取本机端口号
                String RemotePort = ":" + socket.getLocalPort();
                System.out.println("服务器：有一个用户进来了! IP 地址为：" + RemoteIP + RemotePort);
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader( inputStream));
                //	获取用户输入的内容
                String str = "";
                //3，读取数据
                while ( (str = reader.readLine()) != null){
                    System.out.println("客户端发来了：" + str);
                }
                socket.shutdownInput();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter( outputStream);
                writer.write("这里是服务器端");
                writer.flush();
                System.out.println("response!");
                //	关闭资源

                socket.shutdownOutput();
                writer.close();
                reader.close();
                inputStream.close();
                outputStream.close();
            }catch (Exception e){
                System.out.println("error "+e.toString());
            }

        }
    }

    ZygoteServer() {
    }
    void registerServerSocketFromEnv(String socketName) {
           System.out.println("registerServerSocketFromEnv "+socketName);

           if( mServerSocket == null ){
                try{
                    mServerSocket = new ServerSocket( 10000);
                }catch( Exception e ){

                    System.out.println("error "+e.toString());
                }
           }
    }

    /**
     * Runs the zygote process's select loop. Accepts new connections as
     * they happen, and reads commands from connections one spawn-request's
     * worth at a time.
     *
     */
    void  runSelectLoop(String abiList) {
         System.out.println("runSelectLoop "+abiList);

         while (true) {
            try{
                System.out.println("等待客户端连接 \n");
                socket = mServerSocket.accept();
                ServerSocketThread socketThread = new ServerSocketThread(socket);
                socketThread.start();
            }catch(Exception e){
                 System.out.println("error "+e.toString());
            }
         }
    }

    void closeServerSocket() {
        System.out.println("closeServerSocket ");
        try {
            if (mServerSocket != null) {
                mServerSocket.close();
            }
        } catch (Exception ex) {
            System.out.println( "Zygote:  error closing sockets"+ ex.toString());
        }

        mServerSocket = null;
    }

}