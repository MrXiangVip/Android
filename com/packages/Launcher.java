package com.packages;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wave.Activity;
public class Launcher  extends Activity{

	private	String  apps[]={"设置","图库","日历",
	                        "时钟","文件","通话",
	                        "短信","相机","视频"
	                        };

	public  String className[]={"com.packages.Settings","com.packages.Picture","com.wave.Calander",
                               "com.wave.Clock","com.wave.Files","com.wave.Telephone",
                               "com.wave.Message","com.wave.Camera","com.wave.Video"
                               };
    protected void onCreate( ) {
		System.out.println("Hello, Launcher");

		JFrame frm = new JFrame("桌面");
        frm.setSize( 480, 640);
        // 创建一个网格布局管理器实例grid，表格为3*3
        GridLayout grid = new GridLayout(3, 3);
        // 设置frm的页面布局为grid
        frm.setLayout(grid);
        // 定义一个JButton的数组b，数组长度为9
        JButton[] btn = new JButton[9];
        for(int i=0; i< btn.length; i++) {
            btn[i] = new JButton( apps[i]);
            final String name= className[i];
            btn[i].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("按钮被点击了");
                            startActivity( name);
                        }
                    });
            // 将b[i]添加进frm中
            frm.add(btn[i]);
        }
//         do_nothing_on_close(在 windowconstants 中定义)：不执行任何操作；要求程序在已注册的 windowlistener 对象的 windowclosing方法中处理该操作。
//         hide_on_close(在 windowconstants 中定义)：调用任意已注册的 windowlistener 对象后自动隐藏该窗体。
//         dispose_on_close(在 windowconstants 中定义)：调用任意已注册 windowlistener 的对象后自动隐藏并释放该窗体。
//         exit_on_close(在 jframe 中定义)：使用 system exit 方法退出应用程序。仅在应用程序中使用。
//         默认情况下，该值被设置为 hide_on_close。更改此属性的值将导致激发属性更改事件，其属性名称为 "defaultcloseoperation"。
//         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        System.out.println("启动模拟器");
    }

//  性能优化中处理耗时操作
//     public void onWindowFocusChanged(boolean hasWindowFocus) {
//         super.onWindowFocusChanged(hasWindowFocus);
//     }

}