/*
 源码路径
 frameworks/base/core/java/android/app/Activity.java
 */

package com.wave;

import com.wave.view.*;
import com.wave.os.*;
import com.wave.am.ActivityManagerService;
import com.wave.res.Configuration;
import com.wave.app.ActivityThread;


public class Activity extends ContextThemeWrapper implements Window.Callback, KeyEvent.Callback{
// public class Activity{
    private ActivityManagerService  ams;

    private Window mWindow;
    private WindowManager mWindowManager;
    /*package*/public View mDecor = null;
    /*package*/ Configuration mCurrentConfig;


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

    public final void performCreate( ) {
            onCreate( );
    }
    protected void onCreate( ) {
        System.out.println("onCreate ");
    }
    public final void performResume( ) {
        onResume();
    }
    protected void onResume() {
        System.out.println("onResume ");
    }


    public void attach(Context context,  ActivityThread aThread, Configuration config, Window window){
        System.out.println("attach ");
        attachBaseContext(context);

        mUiThread = Thread.currentThread();
        mMainThread = aThread;

        mWindow = new PhoneWindow(this, window);
        mWindow.setCallback( this );
        mWindow.setWindowManager( );
        mWindowManager = mWindow.getWindowManager();
        mCurrentConfig = config;

        ams =ActivityManagerService.getInstance();
    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

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

    public void onContentChanged() {
    }
}
