/*
 源码路径
 frameworks/base/core/java/android/view/ContextThemeWrapper.java
 */
package com.wave;
import com.wave.ContextWrapper;
import com.wave.res.Resources;

public class ContextThemeWrapper extends ContextWrapper {

    private Resources mResources;

    public ContextThemeWrapper() {
        super(null);
    }

    public Resources getResources() {
        return getResourcesInternal();
    }
    private Resources getResourcesInternal() {

        return mResources;
    }
}