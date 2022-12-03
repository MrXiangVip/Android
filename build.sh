#!/bin/bash


VPATH=$(pwd)

cd ${VPATH}/hardware
echo "编译hal层so库"
gcc -fPIC  -I/usr/lib/jvm/java-8-openjdk-amd64/include  -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -shared -o libFreg.so  com_wave_FregService.cpp
export LD_LIBRARY_PATH=$(pwd)/:$LD_LIBRARY_PATH
echo ${LD_LIBRARY_PATH}


cd ${VPATH}/com/wave
echo "生成头文件"
javac -d . Zygote.java
javah -jni com.wave.Zygote
echo $(pwd)
echo "编译动态库"
gcc -fPIC  -I/usr/lib/jvm/java-8-openjdk-amd64/include  -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -shared -o libandroid.so  Zygote.c
export LD_LIBRARY_PATH=$(pwd)/:$LD_LIBRARY_PATH


cd ${VPATH}
echo $(pwd)
echo "编译app_process"
javac       com/wave/ZygoteInit.java
javac       com/wave/SystemServer.java
gcc -D__int64="long long" -I/usr/lib/jvm/java-8-openjdk-amd64/include  -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -o app_process app_process.c  -L/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server -ljvm

echo "编译package app"
javac  com/packages/Launcher.java
javac  com/packages/Settings.java
javac  com/packages/Picture.java
echo "执行.."
./app_process
