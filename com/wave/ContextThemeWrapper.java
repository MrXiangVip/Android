/*
 源码路径
 frameworks/base/core/java/android/view/ContextThemeWrapper.java
 */
package com.wave;
import com.wave.ContextWrapper;
import com.wave.res.Resources;
import com.wave.Context;


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

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

}