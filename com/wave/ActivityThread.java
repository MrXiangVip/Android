
package com.wave;

import com.wave.ContextImpl;
import com.wave.Handler;
public final class ActivityThread  {


    private ContextImpl mSystemContext;

    public static ActivityThread systemMain() {
        // The system process on low-memory devices do not get to use hardware
        // accelerated drawing, since this can add too much overhead to the
        // process.
        System.out.println("--systemMain--");
        ActivityThread thread = new ActivityThread();
//         thread.attach(true, 0);
        return thread;
//         return null;
    }

    ActivityThread() {
        System.out.println("--ActivityThread--");

//             mResourcesManager = ResourcesManager.getInstance();
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
//         thread.attach(false, 0);

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
//     private void attach(boolean system, long startSeq) {
//             final IActivityManager mgr = ActivityManager.getService();
//             try {
//                 mgr.attachApplication(mAppThread, startSeq);
//             } catch (RemoteException ex) {
//                 throw ex.rethrowFromSystemServer();
//             }
//     }
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