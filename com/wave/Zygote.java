/*
 源码路径
 frameworks/base/core/java/com/android/internal/os/Zygote.java
 */
package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;

public final class Zygote{

    native private static int nativeForkSystemServer();
    native private static int nativeForkAndSpecialize();
// 创建系统进程
    public static int forkSystemServer(){
                System.out.println("forkSystemServer \n");
                int pid = nativeForkSystemServer();
                return pid;
    }

// 创建一个进程
    public static int forkAndSpecialize() {
        // Resets nice priority for zygote process.
        int pid = nativeForkAndSpecialize();
        // Enable tracing as soon as possible for the child process.
        if (pid == 0) {

        }
        return pid;
    }
}