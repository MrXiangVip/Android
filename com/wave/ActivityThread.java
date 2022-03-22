
package com.wave;

import com.wave.ContextImpl;
import com.wave.Handler;
import com.wave.Activity;
public final class ActivityThread  {


    private ContextImpl mSystemContext;
    private boolean mSystemThread = false;

    public static final class ActivityClientRecord {
        Activity activity;
    }
    public static ActivityThread systemMain() {
        // The system process on low-memory devices do not get to use hardware
        // accelerated drawing, since this can add too much overhead to the
        // process.
        System.out.println("--systemMain--");
        ActivityThread thread = new ActivityThread();
        thread.attach(true, 0);
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
    public static void main(String[] args) {
        System.out.println("--main--");
        Looper.prepareMainLooper();

        ActivityThread thread = new ActivityThread();
        thread.attach(false, 0);
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
    private void attach(boolean system, long startSeq) {
            mSystemThread = system;
            if( !system ){
                   System.out.println(" 附上非系统进程 ");
//                 final IActivityManager mgr = ActivityManager.getService();
//                 try {
//                     mgr.attachApplication(mAppThread, startSeq);
//                 } catch (RemoteException ex) {
//                     throw ex.rethrowFromSystemServer();
//                 }
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

    private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        Activity activity = null;
        return activity;
    }
//     public Activity handleLaunchActivity(ActivityClientRecord r,
//             PendingTransactionActions pendingActions, Intent customIntent) {
//         System.out.println("handleLaunchActivity " );
//
//     }

//     public void handleResumeActivity(IBinder token, boolean finalStateRequest, boolean isForward,String reason) {
//         System.out.println("handleResumeActivity " );
//
//     }

}