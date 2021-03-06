//
// Created by xshx on 2021/5/25.
//
// 相当于 Android_9.0.0_2.0.0-ga/frameworks/base/core/jni/com_android_internal_os_Zygote.cpp
#include "jni.h"
#include "com_wave_Zygote.h"
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>



JNIEXPORT jint JNICALL Java_com_wave_Zygote_nativeForkSystemServer (JNIEnv *env, jobject obj){
    printf("fork \n");
    pid_t fpid = fork();
    if( fpid == 0 ){
        printf("这里是子进程 ID :%d \n",getpid());

        jclass launcher_class;
        jmethodID main_method;
//        launcher_class =(*env)->FindClass(env, "com/wave/Launcher");
        launcher_class =(*env)->FindClass(env, "com/wave/SystemServer");
        main_method =(*env)->GetStaticMethodID(env, launcher_class, "main","([Ljava/lang/String;)V");
        (*env)->CallStaticVoidMethod(env,launcher_class, main_method, NULL);
        if ((*env)->ExceptionCheck(env)) {
            printf("Error calling post fork hooks. \n");
        }
        printf("start launcher.main \n");

    }else {
        printf("这是zygote 进程 ID :%d \n", getpid());
        printf("System server process %d has been created %d", fpid);
        int status;
        if (waitpid(fpid, &status, WNOHANG) == fpid) {
            printf("System server process %d has died. Restarting Zygote!", fpid);
        }
    }

    return fpid;
}