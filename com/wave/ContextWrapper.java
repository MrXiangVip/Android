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

}
