/*
* xshx add
* path: frameworks/base/services/core/java/com/android/server/am/ActivityManagerService.java
*/

package com.wave;

import com.wave.WindowManagerService;
import com.wave.Process.ProcessStartResult;
public class ActivityManagerService{



    WindowManagerService mWindowManager;
    private static ActivityManagerService  ams;

    private ActivityManagerService( ){
        System.out.println("初始化ActivityManagerService");
    }

    public static ActivityManagerService getInstance( ){
        if (ams == null) {
             ams = new ActivityManagerService( );
        }
        return ams;
    }
    private void start() {

        System.out.println("ActivityManagerService start ");
    }


    public static final class Lifecycle extends SystemService {
        private final ActivityManagerService mService;

        public Lifecycle( ) {
            super( );
            mService = new ActivityManagerService( );
        }

        public void onStart() {
            mService.start();
        }


        public ActivityManagerService getService() {
            return mService;
        }
    }

    public void systemReady() {

         startHomeActivityLocked( "systemReady");

    }

    boolean startHomeActivityLocked( String reason) {
        System.out.println("startHomeActivityLocked\n");
        if( true ){
            startActivity("com.wave.Launcher");
        }
         return true;
    }


    public void setWindowManager(WindowManagerService wm) {
        System.out.println("ActivityManagerService setWindowManager");
        synchronized (this) {
            mWindowManager = wm;
//             mStackSupervisor.setWindowManager(wm);
//             mLockTaskController.setWindowManager(wm);
        }
    }

    public final int startActivity( String callingPackageClass ){
        System.out.println("ActivityManagerService startActivity "+callingPackageClass);
        startProcessLocked( callingPackageClass );
        return 0;
    }

    private boolean startProcessLocked(String callingPackageClass ){
         System.out.println("ActivityManagerService startProcessLocked "+callingPackageClass);
         startProcess( callingPackageClass );
         return true;
    }

    private ProcessStartResult startProcess(String callingPackageClass ){
        System.out.println("ActivityManagerService startProcess "+callingPackageClass);
        return Process.start(callingPackageClass);
    }

}