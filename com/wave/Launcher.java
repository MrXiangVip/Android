package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher  extends Activity{

	private	String  apps[]={"设置","图库","日历",
	                        "时钟","文件","通话",
	                        "短信","相机","视频"
	                        };

	public  String className[]={"com.wave.Settings","com.wave.Picture","com.wave.Calander",
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
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        System.out.println("启动模拟器");
    }

//  性能优化中处理耗时操作
//     public void onWindowFocusChanged(boolean hasWindowFocus) {
//         super.onWindowFocusChanged(hasWindowFocus);
//     }

}