

package com.wave;

public class Activity extends ContextThemeWrapper{
// public class Activity{

    private Window mWindow;
    /*package*/ ActivityThread mMainThread;
    private Thread mUiThread;
    final Handler mHandler = new Handler();
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

    }

    protected void onCreate( ) {
        System.out.println("onCreate ");
    }

    public void attach( ActivityThread aThread, Window window){
        System.out.println("attach ");
        mUiThread = Thread.currentThread();
        mMainThread = aThread;

        mWindow = new PhoneWindow(this, window);
        mWindow.setWindowManager();

    }
}
