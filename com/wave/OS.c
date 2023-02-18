//
// Created by xshx on 2023/2/18.
//
#include "jni.h"
#include "com_wave_OS.h"
#include <stdio.h>
#include <sys/prctl.h>


JNIEXPORT jint JNICALL Java_com_wave_OS_nativePrctl (JNIEnv *env, jobject obj,jstring new_name){
    printf("Java_com_wave_OS_nativePrctl \n");
    char *name = (*env)->GetStringUTFChars(env, new_name, NULL);
    printf("prctl name %s \r\n", name);
    prctl(PR_SET_NAME, new_name);

}
