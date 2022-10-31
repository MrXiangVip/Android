//  相当于 frameworks/base/services/java/com/android/server/SystemServer.java

package com.wave;
import com.wave.pm.PackageManagerService;
import com.wave.Context;
import com.wave.WindowManagerService;
import com.wave.ActivityThread;
import com.wave.PhoneWindowManager;
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

        Looper.prepareMainLooper();
        mSystemServiceManager = new SystemServiceManager();

        createSystemContext();

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

            mActivityManagerService.setWindowManager(wm);
            System.out.println("在这里启动 HomeActivity");

            mActivityManagerService.systemReady();

    }
}