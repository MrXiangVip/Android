//  相当于 frameworks/base/services/java/com/android/server/SystemServer.java

package com.wave;

public final class SystemServer {
    private static final String TAG = "SystemServer";

    private SystemServiceManager mSystemServiceManager;
    private ActivityManagerService mActivityManagerService;


    public static void main(String[] args) {
            new SystemServer().run();
    }
    private void run() {
        mSystemServiceManager = new SystemServiceManager();

        try {
            System.out.println("StartServices");
            startBootstrapServices();
            startCoreServices();
            startOtherServices();
        } catch (Throwable ex) {
            System.out.println("SystemServer******************************************");
            System.out.println("SystemServer************ Failure starting system services");
        } finally {
            System.out.println("finally ");
        }
    }

    private void startBootstrapServices() {
            System.out.println( "Reading configuration...");
            mActivityManagerService = mSystemServiceManager.startService(
                            ActivityManagerService.Lifecycle.class).getService();
    }

    private void startCoreServices() {
            System.out.println("StartBatteryService");
    }

    private void startOtherServices() {
            System.out.println("startOtherServices");
            System.out.println("在这里启动 HomeActivity");
            mActivityManagerService.systemReady();

    }
}