
package com.wave;

import com.wave.WindowManagerService;
import com.wave.Process.ProcessStartResult;
public class ActivityManagerService{

    WindowManagerService mWindowManager;

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
             Launcher.main(new String[] {ActivityManagerService.class.getName()});
        }else{
    //       ActivityManagerService 4466 行
             System.out.println("在这里分裂出应用进程");
             String processName ="Launcher";
             ProcessStartResult startResult = Process.start("com.wave.ActivityThread",
                                      processName, null);
        }

         return true;
    }


    public void setWindowManager(WindowManagerService wm) {
        synchronized (this) {
            mWindowManager = wm;
//             mStackSupervisor.setWindowManager(wm);
//             mLockTaskController.setWindowManager(wm);
        }
    }
}