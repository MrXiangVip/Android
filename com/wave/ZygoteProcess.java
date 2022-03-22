
package com.wave;
import java.util.ArrayList;

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

    public final Process.ProcessStartResult start(final String processClass,
                                                  final String niceName,
                                                  String[] zygoteArgs) {
        try {
            return startViaZygote(processClass, niceName,
                    zygoteArgs);
        } catch (RuntimeException ex) {
            System.out.println(
                    "Starting VM process through Zygote failed");
            throw new RuntimeException(
                    "Starting VM process through Zygote failed", ex);
        }
    }


    private Process.ProcessStartResult startViaZygote(final String processClass,
                                                      final String niceName,
                                                      String[] extraArgs){
        ArrayList<String> argsForZygote = new ArrayList<String>();

        // --runtime-args, --setuid=, --setgid=,
        // and --setgroups= must go first

        if (extraArgs != null) {
            for (String arg : extraArgs) {
                argsForZygote.add(arg);
            }
        }

        synchronized(mLock) {
            return zygoteSendArgsAndGetResult( argsForZygote);
        }
    }

    private static Process.ProcessStartResult zygoteSendArgsAndGetResult(
             ArrayList<String> args){

        System.out.println("请求创建进程");
        return null;
    }
}