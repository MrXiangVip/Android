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
import com.wave.FregService;

public class Settings  extends Activity{

	    private	String  items[]={"WLAN","蓝牙","移动网络",
	                        "桌面和壁纸","显示和亮度","电池",
	                        "存储","安全","隐私"
	                        };
        static {
            System.loadLibrary( "Freg");
        }
        protected void onCreate( ) {
    		System.out.println("Hello, Settings");
    		FregService service = new FregService();
            JFrame frame = new JFrame("Settings");
            frame.setSize( 480, 640);
            JPanel contentPane=new JPanel();    //创建内容面板
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    //设置面板的边框
            contentPane.setLayout(new BorderLayout(0, 0));    //设置内容面板为边界布局
            frame.setContentPane(contentPane);    //应用内容面板
            JScrollPane scrollPane=new JScrollPane();    //创建滚动面板
            contentPane.add(scrollPane,BorderLayout.CENTER);    //将面板增加到边界布局中央
            JList list=new JList();
            //限制只能选择一个元素
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane.setViewportView(list);    //在滚动面板中显示列表
//             String[] listData=new String[12];    //创建一个含有12个元素的数组
//             for (int i=0;i<listData.length;i++)
//             {
//                 listData[i]="这是列表框的第"+(i+1)+"个元素~";    //为数组中各个元素赋值
//             }
//             list.setListData(listData);    //为列表填充数据
            list.setListData(items);    //为列表填充数据
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println("设置frm 可见");
            frame.setVisible(true);
            System.out.println("启动设置");

        }
}