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
            JFrame frm = new JFrame("Settings");
            frm.setSize( 480, 640);
            GridLayout grid = new GridLayout(3, 3);
            // 设置frm的页面布局为grid
            frm.setLayout(grid);
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setVisible(true);
            System.out.println("启动设置");

        }
}