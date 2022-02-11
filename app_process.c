//
// Created by xshx on 2021/5/22.
//

#include<stdio.h>
#include<jni.h>

JNIEnv* create_vm(JavaVM **jvm)
{
    printf("%s\n",__func__);
    JNIEnv* env;
    JavaVMInitArgs args;
    JavaVMOption options;
    args.version = JNI_VERSION_1_8;
    args.nOptions = 1;
    options.optionString ="-Djava.class.path=./";
    args.options = &options;
    args.ignoreUnrecognized = 0;
    int rv;
    rv = JNI_CreateJavaVM(jvm,(void**)&env, &args);
    if (rv < 0 || !env)
        printf("Unable to Launch JVM%d\n",rv);
    else
        printf("Launched JVM! :)\n");
    return env;
}


void invoke_class(JNIEnv* env)
{
    printf("%s\n",__func__);
    jclass zygote_init_class;
    jmethodID main_method;

    zygote_init_class =(*env)->FindClass(env, "com/wave/ZygoteInit");
    main_method =(*env)->GetStaticMethodID(env, zygote_init_class, "main","([Ljava/lang/String;)V");
    (*env)->CallStaticVoidMethod(env,zygote_init_class, main_method, NULL);
}


int main(int argc,char **argv)
{
    JavaVM *jvm;
    JNIEnv *env;
    env = create_vm(&jvm);
    if(env == NULL)
        return 1;
    invoke_class(env);

    return 0;
}