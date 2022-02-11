package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;

public final class Zygote{

    native private static int nativeForkSystemServer();

    public static int forkSystemServer(){
                System.out.println("forkSystemServer");
                int pid = nativeForkSystemServer();
                return pid;
    }


}