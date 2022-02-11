// 参考android 9 源码  ZygoteInit.java 文件
package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;

public class ZygoteInit{

    public native void helloWorld(); // 注意，这个native方法就是调用C语言接口用的

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

    private static Runnable forkSystemServer(String abiList, String socketName,
                ZygoteServer zygoteServer) {
        int pid;
        pid = Zygote.forkSystemServer();
        System.out.println(" pid " + pid);
        return null;
    }
	public static void main(String[] args){
		System.out.println("Hello, ZygoteInit");
		String abiList = null;
        String socketName = "zygote";

		ZygoteServer zygoteServer = new ZygoteServer();
        preload();
        boolean startSystemServer = true;
        if (startSystemServer) {
                Runnable r = forkSystemServer(abiList, socketName, zygoteServer);
                // {@code r == null} in the parent (zygote) process, and {@code r != null} in the
                // child (system_server) process.
                if (r != null) {
                    r.run();
                    return;
                }
        }

        zygoteServer.runSelectLoop(abiList);
	}


}