读万卷书，不如动手实现

模拟实现android 的框架层

运行环境:
    ubuntu 20.04   环境下 运行 build.sh

错误1：

    xshx@xshx:~/code/weidongshan/emulator$ make
    javac com/wave/ZygoteInit.java
    ./app_process
    ./app_process: error while loading shared libraries: libjvm.so: cannot open shared object file: No such file or directory
    make: *** [Makefile:10：run] 错误 127

解决方法：

    sudo vim /etc/ld.so.conf
    在文件末尾新添加一行：
    /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server
    这个路径指向libjvm.so 文件


![Image text](https://github.com/MrXiangVip/Android/blob/master/image/20220907190153.png)

参考资料：

https://blog.csdn.net/yuhentian/article/details/79945112

https://blog.csdn.net/u011181989/article/details/92242435

https://blog.csdn.net/Luoshengyang/article/details/8170307?spm=1001.2014.3001.5502

<<android系统源代码情景分析>>  罗升阳 编著

<<深入理解Android内核设计思想>> 林学森 编著

