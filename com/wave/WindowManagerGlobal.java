/*
* xshx
* path: frameworks/base/core/java/android/view/WindowManagerGlobal.java
*/

package com.wave;

import java.util.ArrayList;


public final class WindowManagerGlobal {
    private static final String TAG = "WindowManager";
    private static WindowManagerGlobal sDefaultWindowManager;

    private final ArrayList<View> mViews = new ArrayList<View>();
    private final ArrayList<ViewRootImpl> mRoots = new ArrayList<ViewRootImpl>();
    private final ArrayList<WindowManager.LayoutParams> mParams =
            new ArrayList<WindowManager.LayoutParams>();

    private WindowManagerGlobal() {
        System.out.println(" WindowManagerGlobal 构造函数 ");
    }


    public static WindowManagerGlobal getInstance() {
        synchronized (WindowManagerGlobal.class) {
            if (sDefaultWindowManager == null) {
                sDefaultWindowManager = new WindowManagerGlobal();
            }
            return sDefaultWindowManager;
        }
    }
    public void addView(View view, ViewGroup.LayoutParams params,
             Window parentWindow) {
        System.out.println(" WindowManagerGlobal addView ");


    }
    public void removeView(View view, boolean immediate) {
        System.out.println(" WindowManagerGlobal removeView ");
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        System.out.println(" WindowManagerGlobal updateViewLayout ");
    }
}