/*
 源码路径
 frameworks/base/core/java/android/os/ZygoteProcess.java
 */
package com.wave.os;
import java.util.ArrayList;
import java.net.Socket;
import java.io.*;
import com.wave.net.LocalSocketAddress;

public class ZygoteProcess {
    private static final String LOG_TAG = "ZygoteProcess";

    private final Object mLock = new Object();
    /**
     * The name of the socket used to communicate with the primary zygote.
     */
    private final LocalSocketAddress mSocket;

    /**
     * The name of the secondary (alternate ABI) zygote socket.
     */
    private final LocalSocketAddress mSecondarySocket;
    public ZygoteProcess(String primarySocket, String secondarySocket) {
        this(new LocalSocketAddress(primarySocket, LocalSocketAddress.Namespace.RESERVED),
                new LocalSocketAddress(secondarySocket, LocalSocketAddress.Namespace.RESERVED));
    }

    public ZygoteProcess(LocalSocketAddress primarySocket, LocalSocketAddress secondarySocket) {
        mSocket = primarySocket;
        mSecondarySocket = secondarySocket;
    }

    public final Process.ProcessStartResult start( final String processClass ) {
        System.out.println("start "+processClass);
        try {
            return startViaZygote(processClass);
        } catch (RuntimeException ex) {
            System.out.println(
                    "Starting VM process through Zygote failed");
            throw new RuntimeException(
                    "Starting VM process through Zygote failed", ex);
        }
    }


    private Process.ProcessStartResult startViaZygote(final String processClass ){
         System.out.println("startViaZygote "+processClass);

//         ArrayList<String> argsForZygote = new ArrayList<String>();

        // --runtime-args, --setuid=, --setgid=,
        // and --setgroups= must go first

//         if (extraArgs != null) {
//             for (String arg : extraArgs) {
//                 argsForZygote.add(arg);
//             }
//         }

        synchronized(mLock) {
            return zygoteSendArgsAndGetResult( processClass);
        }
    }

    private static Process.ProcessStartResult zygoteSendArgsAndGetResult( String processClass){

            System.out.println("zygoteSendArgsAndGetResult "+processClass);
            try {
                System.out.println("尝试连接");
//                Socket s = new Socket("172.16.57.224", 502);
                Socket socket = new Socket("localhost", 10000);
                System.out.println("连接成功！");
                //构建IO
                OutputStream outs = socket.getOutputStream();

                PrintWriter writer = new PrintWriter( outs );
                //向服务器端发送一条消息
                String input = processClass;

                writer.write( input );
                writer.flush();
                System.out.println("ZygoteProcess 发送:"+input);
                socket.shutdownOutput();
                //读取服务器返回的消息


                InputStream ins = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
                String msg = "";
                while ( (msg = reader.readLine()) != null){
                    System.out.println("服务器端发来：" + msg);
                }

                reader.close();
                ins.close();
                writer.close();
                outs.close();

//                socket.close();

            } catch (Exception e) {
//                 socket.close();
                e.printStackTrace();
            }
            Process.ProcessStartResult result = new Process.ProcessStartResult();
            return result;
    }
}