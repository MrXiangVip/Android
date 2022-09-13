package com.wave;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ZygoteServer {
    public static final String TAG = "ZygoteServer";

    private ServerSocket mServerSocket;
    private Socket socket;

    private String clientMessage;

//     public class ServerSocketThread extends Thread{
//         private Socket socket;
//         //构造器
//         public ServerSocketThread(Socket socket) {
//             this.socket = socket;
//         }
//         public void run() {
//             //	定义连接端口
//             try{
//                 //	等待客户端连接
//                 String RemoteIP = socket.getInetAddress().getHostAddress();
//                 //	获取本机端口号
//                 String RemotePort = ":" + socket.getLocalPort();
//                 System.out.println("服务器：有一个用户进来了! IP 地址为：" + RemoteIP + RemotePort);
//                 InputStream inputStream = socket.getInputStream();
//                 BufferedReader reader = new BufferedReader(new InputStreamReader( inputStream));
//                 //	获取用户输入的内容
//                 String str = "";
//                 //3，读取数据
//                 while ( (str = reader.readLine()) != null){
//                     System.out.println("客户端发来了：" + str);
//                 }
//                 socket.shutdownInput();
//
//                 int pid = Zygote.forkAndSpecialize(parsedArgs.uid, parsedArgs.gid, parsedArgs.gids,
//                                 parsedArgs.runtimeFlags, rlimits, parsedArgs.mountExternal, parsedArgs.seInfo,
//                                 parsedArgs.niceName, fdsToClose, fdsToIgnore, parsedArgs.startChildZygote,
//                                 parsedArgs.instructionSet, parsedArgs.appDataDir);
//
//                 if( pid ==0 ){
//                     mServerSocket.close();
//
//                 }
//                 OutputStream outputStream = socket.getOutputStream();
//                 PrintWriter writer = new PrintWriter( outputStream);
//                 writer.write("这里是服务器端");
//                 writer.flush();
//                 System.out.println("response!");
//                 //	关闭资源
//
//                 socket.shutdownOutput();
//                 writer.close();
//                 reader.close();
//                 inputStream.close();
//                 outputStream.close();
//             }catch (Exception e){
//                 System.out.println("error "+e.toString());
//             }
//
//         }
//     }

    ZygoteServer() {
    }
    void registerServerSocketFromEnv(String socketName) {
           System.out.println("registerServerSocketFromEnv "+socketName);

           if( mServerSocket == null ){
                try{
                    mServerSocket = new ServerSocket( 10000);
                }catch( Exception e ){
                    e.printStackTrace();
                }
           }
    }

    /**
     * Runs the zygote process's select loop. Accepts new connections as
     * they happen, and reads commands from connections one spawn-request's
     * worth at a time.
     *
     */
    Runnable  runSelectLoop(String abiList) {
         System.out.println("runSelectLoop "+abiList);

         while (true) {
            try{
                System.out.println("等待客户端连接 \n");
                socket = mServerSocket.accept();
//                 ServerSocketThread socketThread = new ServerSocketThread(socket);
//                 socketThread.start();
                String RemoteIP = socket.getInetAddress().getHostAddress();
                //	获取本机端口号
                String RemotePort = ":" + socket.getLocalPort();
                System.out.println("服务器：有一个用户进来了! IP 地址为：" + RemoteIP + RemotePort);
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader( inputStream));
                //	获取用户输入的内容

                //3，读取数据
                clientMessage = reader.readLine();
                System.out.println("客户端发来了：" + clientMessage);

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

                int pid = Zygote.forkAndSpecialize();

                if( pid ==0 ){
                    System.out.println("子进程关掉 server socket");
                    mServerSocket.close();
                    return handleChildProc(clientMessage);
                }else{
                    socket.close();
                    System.out.println("父进程关掉连接的客户端socket");
                }
            }catch(Exception e){
                 e.printStackTrace();
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
            ex.printStackTrace();
        }

        mServerSocket = null;
    }

    private Runnable handleChildProc(String className){
        System.out.println("handleChildProc "+className);
        return ZygoteInit.childZygoteInit( className);
    }
}