// 参考
// android 9 源码  ZygoteInit.java 文件
///frameworks/base/core/java/com/android/internal/os/ZygoteInit.java
package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;
import java.lang.reflect.Method;

public class ZygoteInit{

    public native void helloWorld(); // 注意，这个native方法就是调用C语言接口用的

// frameworks/base/core/java/com/android/internal/os/RuntimeInit.java
    static class MethodAndArgsCaller implements Runnable {
        /** method to call */
//         private final Method mMethod;

        /** argument array */
        private final String mArgs;
        private final String mClassName;
        public MethodAndArgsCaller(String args, String className) {
               System.out.println("MethodAndArgsCaller..."+args +" "+ className);
//             mMethod = method;
            mArgs = args;
            mClassName = className;
        }

        public void run() {
                System.out.println("反射的方式启动 ..."+mArgs +" 参数: "+mClassName);
                Class<?> cl;

                try {
                    cl = Class.forName( mArgs );
                    Method m = cl.getMethod("main",String.class);
                    m.invoke(null, mClassName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
    }

//     static{
//         System.loadLibrary("hello");  // 这行是调用动态链接库
//     }
    static void preload( ) {
          preloadClasses();
          preloadResources();
          preloadSharedLibraries();
    }
    private static void preloadClasses() {
            class PreloadClassThread extends Thread {
                        public void run() {
                                    System.out.println("线程中预加载类资源...");

                        }
            }
            PreloadClassThread thread = new PreloadClassThread();
            thread.start();
            System.out.println("预加载类资源...");

    }
    private static void preloadResources() {
            System.out.println("预加载资源...");

    }
    private static void preloadSharedLibraries() {
            System.out.println("预加载动态库...");
            System.loadLibrary("android");
            System.out.println("加载 libandroid.so  over...");


//             System.loadLibrary("compiler_rt");
//             System.loadLibrary("jnigraphics");
    }
    private static Runnable handleSystemServerProcess(){
        System.out.println("handleSystemServerProcess...");
        return ZygoteInit.zygoteInit( );
    }

    private static Runnable forkSystemServer(String abiList, String socketName,
                ZygoteServer zygoteServer) {
        int pid;
        pid = Zygote.forkSystemServer();
        if( pid ==0 ){
              System.out.println("子进程 pid " + pid);
              zygoteServer.closeServerSocket();
              return handleSystemServerProcess();
        }
        System.out.println("父进程 pid " + pid+"\n");
        return null;
    }

	public static void main(String[] args){
		System.out.println("Hello, ZygoteInit");
		String abiList = null;
        String socketName = "zygote";

        final Runnable caller;
		ZygoteServer zygoteServer = new ZygoteServer();
		zygoteServer.registerServerSocketFromEnv(socketName);

        preload();
        boolean startSystemServer = true;
        if (startSystemServer) {
                Runnable r = forkSystemServer(abiList, socketName, zygoteServer);
                // {@code r == null} in the parent (zygote) process, and {@code r != null} in the
                // child (system_server) process.
                if (r != null) {
                    System.out.println("准备启动 system_server");
                    r.run();
                    return;
                }
        }

        caller = zygoteServer.runSelectLoop(abiList);
        if( caller != null ){
            caller.run();
        }
	}

    public static final Runnable zygoteInit( ) {
        System.out.println("zygoteInit  这里启动 systemserver  ");
        return new MethodAndArgsCaller("com.wave.SystemServer","system_server");
    }

    static final Runnable childZygoteInit(String className) {
        System.out.println("childZygoteInit  这里启动 activitythread "+className);
        return new MethodAndArgsCaller("com.wave.ActivityThread", className);
    }
}