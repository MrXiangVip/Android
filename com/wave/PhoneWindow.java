/*
 源码路径
 frameworks/base/core/java/com/android/internal/policy/PhoneWindow.java
 */
package com.wave;
import com.wave.view.*;
import com.wave.view.LayoutInflater;

public class PhoneWindow extends Window{
    private DecorView mDecor;
    ViewGroup mContentParent;
    private LayoutInflater mLayoutInflater;

    public PhoneWindow(Context context, Window preservedWindow){
        System.out.println("PhoneWindow");
    }

    public void setContentView(int layoutResID) {
        System.out.println("setContentView"+layoutResID);

    }

    public void setContentView(View view) {
        System.out.println("setContentView"+view);
        installDecor();
    }
    public final View getDecorView() {
        if (mDecor == null ) {
            installDecor();
        }
        return mDecor;
    }
    private void installDecor() {
        System.out.println("installDecor");
        if (mDecor == null) {
                mDecor = generateDecor(-1);
        }

        if (mContentParent == null) {
            mContentParent = generateLayout(mDecor);
        }
    }

    protected DecorView generateDecor(int featureId) {
        System.out.println("generateDecor "+featureId);
        return new DecorView( featureId, this, getAttributes());

    }

    protected ViewGroup generateLayout(DecorView decor) {
        System.out.println("generateLayout");
        mDecor.onResourcesLoaded(mLayoutInflater);
        ViewGroup contentParent = (ViewGroup)findViewById(ID_ANDROID_CONTENT);
        return contentParent;
    }
}