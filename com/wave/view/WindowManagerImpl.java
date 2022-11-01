/*
* xshx
* path :android/view/WindowManagerImpl.java
* path :frameworks/base/core/java/android/view/WindowManagerImpl.java
*/

package com.wave.view;

import com.wave.Context;
public  class WindowManagerImpl implements WindowManager {

    private final WindowManagerGlobal mGlobal = WindowManagerGlobal.getInstance();
    public  Context mContext;
    private Window mParentWindow;


    public WindowManagerImpl( ) {
        System.out.println("WindowManagerImpl");
//         this( null);
    }

    private WindowManagerImpl( Window parentWindow) {
        System.out.println("WindowManagerImpl");
        mParentWindow = parentWindow;
    }
    public WindowManagerImpl createLocalWindowManager(Window parentWindow) {
        System.out.println("createLocalWindowManager");
        return new WindowManagerImpl( parentWindow);
    }

    public void removeView(View view) {
        mGlobal.removeView(view, false);
    }

    public void updateViewLayout(View view,  ViewGroup.LayoutParams params) {
//         applyDefaultToken(params);
        mGlobal.updateViewLayout(view, params);
    }

    public void addView(View view,  ViewGroup.LayoutParams params) {
//         applyDefaultToken(params);
        mGlobal.addView(view, params,  mParentWindow);
    }
}