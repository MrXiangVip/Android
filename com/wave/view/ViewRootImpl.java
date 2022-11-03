/*
*  xshx
*  path: frameworks/base/core/java/android/view/ViewRootImpl.java
*/

package com.wave.view;

import com.wave.view.InputChannel;

public final class ViewRootImpl implements ViewParent{

    View mView;
    boolean mAdded;
    InputChannel mInputChannel;

    public ViewRootImpl( ) {
        System.out.println("ViewRootImpl 构造函数");
        mAdded = false;

    }

    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        System.out.println("ViewRootImpl setView");
        if( mView == null ){
            mView = view;

            mAdded = true;

            mInputChannel = new InputChannel();
//          此处会调到wms 的addWindow

        }
    }

//     private void performTraversals() {
//         System.out.println("performTraversals");
//
//     }



}

