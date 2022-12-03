/*
 源码路径
 frameworks/base/core/java/android/view/LayoutInflater.java
 */

package com.wave.view;

import com.wave.Context;
import com.wave.policy.PhoneLayoutInflater;
import com.wave.res.XmlResourceParser;
import com.wave.res.Resources;

import org.xmlpull.v1.XmlPullParser;

public abstract class LayoutInflater {

    protected  static Context mContext;

    protected LayoutInflater(Context context) {
        mContext = context;
        initPrecompiledViews();
    }

    public Context getContext() {
        return mContext;
    }
    public static LayoutInflater from(Context context) {
//     LAYOUT_INFLATER_SERVICE  实际拿到的是 PhoneLayoutInflater
//         LayoutInflater LayoutInflater =
//                 (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//         if (LayoutInflater == null) {
//             throw new AssertionError("LayoutInflater not found.");
//         }
        mContext = context;
        LayoutInflater layoutInflater = new PhoneLayoutInflater( context );
        return layoutInflater;
    }

    private void initPrecompiledViews() {
        // Precompiled layouts are not supported in this release.
        boolean enabled = false;
        initPrecompiledViews(enabled);
    }

    private void initPrecompiledViews(boolean enablePrecompiledViews) {

        return;
    }

    public View inflate( int resource,  ViewGroup root) {
        return inflate(resource, root, root != null);
    }

    public View inflate( int resource,  ViewGroup root, boolean attachToRoot) {
//         final Resources res = getContext().getResources();
        final Resources res = new Resources();
        XmlResourceParser parser = res.getLayout(resource);
        try{
            return inflate(parser, root, attachToRoot);

        }finally{
             parser.close();
        }
    }

    public View inflate(XmlPullParser parser,  ViewGroup root, boolean attachToRoot) {

            View result = root;
            return result;

    }

}