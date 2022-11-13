/*
* 源码路径
* path: frameworks/base/core/java/android/view/WindowManagerGlobal.java
*/

package com.wave.view;

import java.util.ArrayList;


public final class WindowManagerGlobal {
    private static final String TAG = "WindowManager";

    public static final int ADD_OKAY = 0;
    public static final int ADD_BAD_APP_TOKEN = -1;
    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    public static final int ADD_NOT_APP_TOKEN = -3;
    public static final int ADD_APP_EXITING = -4;
    public static final int ADD_DUPLICATE_ADD = -5;
    public static final int ADD_STARTING_NOT_NEEDED = -6;
    public static final int ADD_MULTIPLE_SINGLETON = -7;
    public static final int ADD_PERMISSION_DENIED = -8;
    public static final int ADD_INVALID_DISPLAY = -9;
    public static final int ADD_INVALID_TYPE = -10;

    private final Object mLock = new Object();

    private static WindowManagerGlobal sDefaultWindowManager;

    private final ArrayList<View> mViews = new ArrayList<View>();
    private final ArrayList<ViewRootImpl> mRoots = new ArrayList<ViewRootImpl>();
    private final ArrayList<WindowManager.LayoutParams> mParams =
            new ArrayList<WindowManager.LayoutParams>();

    private WindowManagerGlobal() {
        System.out.println("WindowManagerGlobal 构造函数 ");
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
        final WindowManager.LayoutParams wparams = (WindowManager.LayoutParams) params;
        ViewRootImpl root;
        View panelParentView = null;

        synchronized (mLock) {
            root = new ViewRootImpl();
            view.setLayoutParams(wparams);
            mViews.add(view);
            mRoots.add(root);
            mParams.add(wparams);
            // do this last because it fires off messages to start doing things
            try {
                root.setView(view, wparams, panelParentView);
            } catch (Exception e) {
                // BadTokenException or InvalidDisplayException, clean up.
                e.printStackTrace();
            }
        }
    }
    public void removeView(View view, boolean immediate) {
        System.out.println(" WindowManagerGlobal removeView ");
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        System.out.println(" WindowManagerGlobal updateViewLayout ");
    }
}