/*
 源码路径
 frameworks/base/core/java/android/view/Window.java
 */
package com.wave.view;
import com.wave.view.WindowManagerImpl;
import com.wave.Context;

public abstract class Window {

    public static final int ID_ANDROID_CONTENT = 16908290;
    private final Context mContext;
    private Callback mCallback;

//     public abstract void setContentView(View view, ViewGroup.LayoutParams params);

//     public abstract @NonNull View getDecorView();
    private final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    private WindowManager mWindowManager;

    public abstract View getDecorView();

    public abstract void setContentView(int layoutResID);

    public abstract void setContentView(View view);

    public Window(Context context) {
        mContext = context;
//         mFeatures = mLocalFeatures = getDefaultFeatures(context);
    }

    public final Context getContext() {
        return mContext;
    }

    public void setWindowManager( ){
        System.out.println("Window setWindowManager");
//         if (wm == null) {
//             wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
//         }
        WindowManagerImpl wm = new WindowManagerImpl();
        mWindowManager = wm.createLocalWindowManager(this);

    }

    public WindowManager getWindowManager() {
        System.out.println("Window getWindowManager");
        return mWindowManager;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    /**
     * Return the current Callback interface for this window.
     */
    public final Callback getCallback() {
        return mCallback;
    }

    public final WindowManager.LayoutParams getAttributes() {
        return mWindowAttributes;
    }

    public <T extends View> T findViewById(int id) {
        return getDecorView().findViewById(id);
    }

    public interface Callback {

        public void onContentChanged();

    }
}
