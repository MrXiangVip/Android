
/*
 *xshx add : picture 20220927
 */
package com.packages;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.lang.Thread;
import java.lang.Exception;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import com.wave.Activity;

public class Picture  extends Activity{



        protected void onCreate( ) {
    		System.out.println("Hello, Picture");
            JFrame frame = new JFrame("Picture");
            frame.setSize( 480, 640);
            JPanel contentPane=new JPanel();    //创建内容面板
            JLabel label = new JLabel();
            ImageIcon img = new ImageIcon("../../image/20211012043155.jpg");// 创建图片对象
            label.setIcon(img);
            contentPane.add(label);
            frame.add(contentPane);
            System.out.println("设置frm 可见");
            frame.setVisible(true);
            System.out.println("启动设置");

        }
}