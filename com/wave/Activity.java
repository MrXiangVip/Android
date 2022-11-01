

package com.wave;

import com.wave.view.Window;
import com.wave.view.*;
public class Activity extends ContextThemeWrapper{
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

    public void attach( ActivityThread aThread, Window window){
        System.out.println("attach ");
        mUiThread = Thread.currentThread();
        mMainThread = aThread;

        mWindow = new PhoneWindow(this, window);
        mWindow.setWindowManager( );
        mWindowManager = mWindow.getWindowManager();

        ams =ActivityManagerService.getInstance();
    }
}
