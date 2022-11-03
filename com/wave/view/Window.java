/*
 源码路径
 frameworks/base/core/java/android/view/Window.java
 */
package com.wave.view;
import com.wave.view.WindowManagerImpl;
public abstract class Window {

    public static final int ID_ANDROID_CONTENT = 16908290;

//     public abstract void setContentView(View view, ViewGroup.LayoutParams params);

//     public abstract @NonNull View getDecorView();
    private final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    private WindowManager mWindowManager;

    public abstract View getDecorView();

    public abstract void setContentView(int layoutResID);

    public abstract void setContentView(View view);

    public void setWindowManager( ){
        System.out.println("Window setWindowManager");
        WindowManagerImpl wml = new WindowManagerImpl();
        mWindowManager = wml.createLocalWindowManager(this);

    }

    public WindowManager getWindowManager() {
        System.out.println("Window getWindowManager");
        return mWindowManager;
    }

    public final WindowManager.LayoutParams getAttributes() {
        return mWindowAttributes;
    }

    public <T extends View> T findViewById(int id) {
        return getDecorView().findViewById(id);
    }
}
