
package com.wave;

import com.wave.WindowManagerService;
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

          Launcher.main(new String[] {ActivityManagerService.class.getName()});
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