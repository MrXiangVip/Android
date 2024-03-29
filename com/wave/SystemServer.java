/*
    源码路径:
    frameworks/base/services/java/com/android/server/SystemServer.java
 */

package com.wave;
import com.wave.os.*;
import com.wave.pm.PackageManagerService;
import com.wave.Context;
import com.wave.wm.WindowManagerService;
import com.wave.app.ActivityThread;
import com.wave.PhoneWindowManager;
import com.wave.input.InputManagerService;
import com.wave.am.ActivityManagerService;
import com.wave.OS;

public final class SystemServer {
    private static final String TAG = "SystemServer";

    private SystemServiceManager mSystemServiceManager;
    private ActivityManagerService mActivityManagerService;

    private PackageManagerService mPackageManagerService;
    private Context mSystemContext;

    public static void main(String args) {
            System.out.println("SystemServer main "+args);
            new SystemServer().run();
    }
    private void run() {
//      进程重命名为 system_server
        OS.Prctl("system_server");
        Looper.prepareMainLooper();
        mSystemServiceManager = new SystemServiceManager();

        createSystemContext();

        try {
            System.out.println("StartServices");
            startBootstrapServices();
            startCoreServices();
            startOtherServices();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("finally ");
        }
        Looper.loop();

    }

    private void createSystemContext() {
        ActivityThread activityThread = ActivityThread.systemMain();
        mSystemContext = activityThread.getSystemContext();
//         mSystemContext.setTheme(DEFAULT_SYSTEM_THEME);

//         final Context systemUiContext = activityThread.getSystemUiContext();
//         systemUiContext.setTheme(DEFAULT_SYSTEM_THEME);
    }

    private void startBootstrapServices() {
            System.out.println( "Reading configuration...");
//             Installer installer = mSystemServiceManager.startService(Installer.class);
            Installer installer = new Installer();

//             mActivityManagerService = mSystemServiceManager.startService(
//                             ActivityManagerService.Lifecycle.class).getService();
            mActivityManagerService = ActivityManagerService.getInstance();
            mPackageManagerService = PackageManagerService.main(mSystemContext, installer,
                    true, true);
    }

    private void startCoreServices() {
            System.out.println("StartBatteryService");
    }

    private void startOtherServices() {
            System.out.println("startOtherServices");
            final Context context = mSystemContext;
            mPackageManagerService.systemReady();

            InputManagerService inputManager = null;

            WindowManagerService wm = null;

            inputManager = new InputManagerService(context);

            wm = WindowManagerService.main(context, inputManager,
                    true,false, true, new PhoneWindowManager());
//          此处启动系统输入事件
            inputManager.start();

            mActivityManagerService.setWindowManager(wm);
            System.out.println("在这里启动 HomeActivity");

            mActivityManagerService.systemReady();

    }
}