
package com.wave;

public final class OS{

    native private static int nativePrctl(String name );
// 创建系统进程
    public static int Prctl(String name){
                System.out.println("重命名进程  "+name);
                int ret = nativePrctl(name);
                return ret;
    }
}