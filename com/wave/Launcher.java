package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;

public class Launcher  extends Activity{

	public static void main(String[] args){
		System.out.println("Hello, Launcher");
		JFrame frm = new JFrame("模拟器");
        frm.setSize(300, 200);
        // 创建一个网格布局管理器实例grid，表格为3*3
        GridLayout grid = new GridLayout(3, 3);
        // 设置frm的页面布局为grid
        frm.setLayout(grid);
        // 定义一个JButton的数组b，数组长度为9
        JButton[] b = new JButton[9];
        for(int i=0; i<9; i++) {
            b[i] = new JButton(i+1+"");
            // 将b[i]添加进frm中
            frm.add(b[i]);
        }
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        System.out.println("启动模拟器");

	}

    protected void onCreate( ) {
		System.out.println("Hello, Launcher");
		JFrame frm = new JFrame("模拟器");
        frm.setSize(300, 200);
        // 创建一个网格布局管理器实例grid，表格为3*3
        GridLayout grid = new GridLayout(3, 3);
        // 设置frm的页面布局为grid
        frm.setLayout(grid);
        // 定义一个JButton的数组b，数组长度为9
        JButton[] b = new JButton[9];
        for(int i=0; i<9; i++) {
            b[i] = new JButton(i+1+"");
            // 将b[i]添加进frm中
            frm.add(b[i]);
        }
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        System.out.println("启动模拟器");
    }




}