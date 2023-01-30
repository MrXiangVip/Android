/*
 源码路径
 frameworks/base/core/java/android/app/ActivityThread.java
 */
package com.wave.app;

import com.wave.app.ContextImpl;
import com.wave.Activity;
// import java.util.ArrayMap;
import java.util.HashMap;
import com.wave.os.*;
import com.wave.view.*;
import com.wave.res.Configuration;

public final class ActivityThread  {


    private ContextImpl mSystemContext;
    private boolean mSystemThread = false;
    Configuration mCompatConfiguration;


    public static final class ActivityClientRecord {
        Activity activity;
        Window window;
        String className;
    }

    final HashMap<String, ActivityClientRecord> mActivities = new HashMap<>();

    public static ActivityThread systemMain() {
        // The system process on low-memory devices do not get to use hardware
        // accelerated drawing, since this can add too much overhead to the
        // process.
        System.out.println("--systemMain--");
        ActivityThread thread = new ActivityThread();
        thread.attach(true, null);
        return thread;
    }

    ActivityThread() {
        System.out.println("--ActivityThread--");
//      mResourcesManager = ResourcesManager.getInstance();
    }


    public ContextImpl getSystemContext() {
        synchronized (this) {
            if (mSystemContext == null) {
                mSystemContext = ContextImpl.createSystemContext(this);
            }
            return mSystemContext;
        }
    }

    static volatile Handler sMainThreadHandler;  // set once in main()
    final H mH = new H();

    final Handler getHandler() {
            System.out.println("getHandler");
            return mH;
    }
    public static void main(String args) {
        System.out.println("ActivityThread--main--"+args);
        Looper.prepareMainLooper();
        ActivityThread thread = new ActivityThread();
        String className = args;
        thread.attach(false, className);
        if (sMainThreadHandler == null) {
                sMainThreadHandler = thread.getHandler();
        }
        Looper.loop();
    }

    class H extends Handler {

            public void handleMessage(Message msg) {
                System.out.println("msg "+msg.what);
            }
    }
    private void attach(boolean system, String className) {
            System.out.println("attach "+className);
            mSystemThread = system;
            if( !system ){
                   System.out.println("附上非系统进程 ");
//                 final IActivityManager mgr = ActivityManager.getService();
                    Activity activity = handleLaunchActivity(className);

            }else{
                   System.out.println("附上系统进程 ");
//                 try {
//                     mInstrumentation = new Instrumentation();
//                     mInstrumentation.basicInit(this);
//                     ContextImpl context = ContextImpl.createAppContext(
//                             this, getSystemContext().mPackageInfo);
//                     mInitialApplication = context.mPackageInfo.makeApplication(true, null);
//                     mInitialApplication.onCreate();
//                 } catch (Exception e) {
//                     throw new RuntimeException(
//                             "Unable to instantiate Application():" + e.toString(), e);
//                 }
            }

    }
    public Activity handleLaunchActivity(String className){
        System.out.println("handleLaunchActivity "+className);
        ActivityClientRecord r = mActivities.get( className );
        if( r == null ){
            r = new ActivityClientRecord();
            r.className = className;
        }

        Activity activity = performLaunchActivity( r );
        return activity;
    }
    private Activity performLaunchActivity(ActivityClientRecord r) {
        System.out.println("performLaunchActivity "+r.className);
        ContextImpl appContext = createBaseContextForActivity(r);

        if (mCompatConfiguration == null) {
            mCompatConfiguration = new Configuration();
        }
        Configuration config = new Configuration(mCompatConfiguration);

        Activity activity = newActivity( r.className);

        if( activity !=null ){
            Window window = null;

            activity.attach(appContext, this, config,  window);
            activity.performCreate();
        }
        r.activity = activity;
        mActivities.put(r.className, r );
        return activity;
    }
//     public Activity handleLaunchActivity(ActivityClientRecord r,
//             PendingTransactionActions pendingActions, Intent customIntent) {
//         System.out.println("handleLaunchActivity " );
//
//     }

    public void handleResumeActivity( boolean finalStateRequest, boolean isForward,String reason) {
        System.out.println("handleResumeActivity " );
        final ActivityClientRecord r = performResumeActivity(finalStateRequest, reason);
        final Activity a = r.activity;

        r.window = r.activity.getWindow();
        View decor = r.window.getDecorView();
        ViewManager wm = a.getWindowManager();
        WindowManager.LayoutParams l = r.window.getAttributes();
        a.mDecor = decor;
        l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
        wm.addView(decor, l);
    }

    public ActivityClientRecord performResumeActivity( boolean finalStateRequest,String className) {
        System.out.println("performResumeActivity " );
        final ActivityClientRecord r = mActivities.get( className );
        try{
            r.activity.performResume();
        }catch(Exception e){
                e.printStackTrace();
        }
        return r;
    }
    public Activity newActivity(String className){
            System.out.println("newActivity "+className);
            try{
                Class<?> clazz = Class.forName( className );
                Activity activity = (Activity)clazz.newInstance();
                return activity;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
     }

    private ContextImpl createBaseContextForActivity(ActivityClientRecord r) {

        ContextImpl appContext = ContextImpl.createActivityContext(
                this, r.className);
        return appContext;
    }
}