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
参考资料：

https://blog.csdn.net/yuhentian/article/details/79945112
https://blog.csdn.net/u011181989/article/details/92242435

