package com.wave;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings  extends Activity{

        protected void onCreate( ) {
    		System.out.println("Hello, Settings");
            JFrame frame = new JFrame("Settings");
            frame.setSize( 480, 640);
            GridLayout grid = new GridLayout(3, 3);
            // 设置frm的页面布局为grid
            frame.setLayout(grid);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println("设置frm 可见");
            frame.setVisible(true);
            System.out.println("启动设置");

        }
}