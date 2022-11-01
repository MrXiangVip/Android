/*
*  xshx
*  path: frameworks/base/core/java/android/view/ViewRootImpl.java
*/

package com.wave;
public final class ViewRootImpl implements ViewParent{

    public ViewRootImpl( ) {
        System.out.println("ViewRootImpl 构造函数");
    }

    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        System.out.println("ViewRootImpl setView");
    }

    private void performTraversals() {
        System.out.println("performTraversals");

    }
}

