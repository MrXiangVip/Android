/*
 源码路径
 frameworks/base/core/java/android/content/ContextWrapper.java
 */
package com.wave;
public class ContextWrapper extends Context {

    Context mBase;

    public ContextWrapper(Context base) {
        mBase = base;
    }

    protected void attachBaseContext(Context base) {
        if (mBase != null) {
            System.out.println("Base context already set");
            return;
        }
        mBase = base;
    }

}
