/*
 源码路径
 frameworks/base/core/java/com/android/internal/policy/PhoneWindow.java
 */
package com.wave;
import com.wave.view.*;
import com.wave.view.LayoutInflater;
import static com.wave.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class PhoneWindow extends Window{
    private DecorView mDecor;
    ViewGroup mContentParent;
    private LayoutInflater mLayoutInflater;

    public PhoneWindow(Context context){
        super(context);
        mLayoutInflater = LayoutInflater.from(context);
    }
    public PhoneWindow(Context context, Window preservedWindow){
        this(context);
        System.out.println("PhoneWindow");

    }

    public void setContentView(int layoutResID) {
        System.out.println("setContentView"+layoutResID);
        if (mContentParent == null) {
            installDecor();
        }else{
            mContentParent.removeAllViews();
        }

        mLayoutInflater.inflate(layoutResID, mContentParent);
        final Callback cb = getCallback();
        if (cb != null ){
            cb.onContentChanged();
        }
    }

    public void setContentView(View view) {
        System.out.println("setContentView"+view);
        setContentView(view, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        System.out.println("setContentView");
        if (mContentParent == null) {
            installDecor();
        }else{
            mContentParent.removeAllViews();
        }

        mContentParent.addView(view, params);
        final Callback cb = getCallback();
        if (cb != null ){
            cb.onContentChanged();
        }

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
        }else{
            mDecor.setWindow(this);
        }

        if (mContentParent == null) {
            mContentParent = generateLayout(mDecor);
        }
    }

    protected DecorView generateDecor(int featureId) {
        System.out.println("generateDecor "+featureId);
        Context context;
        context = getContext();

        return new DecorView(context, featureId, this, getAttributes());

    }

    protected ViewGroup generateLayout(DecorView decor) {
        System.out.println("generateLayout");
        int layoutResource=0;
        mDecor.onResourcesLoaded(mLayoutInflater, layoutResource);
        ViewGroup contentParent = (ViewGroup)findViewById(ID_ANDROID_CONTENT);
        return contentParent;
    }
}