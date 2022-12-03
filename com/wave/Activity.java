/*
 源码路径
 frameworks/base/core/java/android/app/Activity.java
 */

package com.wave;

import com.wave.view.*;
import com.wave.os.*;
import com.wave.am.ActivityManagerService;

public class Activity extends ContextThemeWrapper implements KeyEvent.Callback{
// public class Activity{
    private ActivityManagerService  ams;

    private Window mWindow;
    private WindowManager mWindowManager;
    /*package*/ View mDecor = null;


    /*package*/ ActivityThread mMainThread;
    private Thread mUiThread;
    final Handler mHandler = new Handler();

    public WindowManager getWindowManager() {
        return mWindowManager;
    }

    public Window getWindow() {
        return mWindow;
    }

    public void setContentView(int layoutResID) {
        System.out.println("setContentView ");
        getWindow().setContentView(layoutResID);
    }

    public void setContentView(View view) {
         System.out.println("setContentView ");
         getWindow().setContentView(view );
    }

    public void startActivity(String className){
        System.out.println("startActivity "+className);
        ams.startActivity( className );
    }

    protected void onCreate( ) {
        System.out.println("onCreate ");
    }

    protected void onResume() {
        System.out.println("onResume ");
    }

    public void attach( ActivityThread aThread, Window window){
        System.out.println("attach ");
        mUiThread = Thread.currentThread();
        mMainThread = aThread;

        mWindow = new PhoneWindow(this, window);
        mWindow.setWindowManager( );
        mWindowManager = mWindow.getWindowManager();

        ams =ActivityManagerService.getInstance();
    }


    public boolean dispatchKeyEvent(KeyEvent event) {
        System.out.println("dispatchKeyEvent");
        Window win = getWindow();
        View decor = mDecor;
        if (decor == null) decor = win.getDecorView();
        return event.dispatch(this,  this);

    }
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }
    public boolean onKeyUp(int keyCode, KeyEvent event) {
         return false;
    }
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        System.out.println("onKeyDown");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
                onBackPressed();
                return true;
        }

        return false;
    }
    public void onBackPressed() {
        System.out.println("onBackPressed");
//         if (mActionBar != null && mActionBar.collapseActionView()) {
//             return;
//         }
    }

}
