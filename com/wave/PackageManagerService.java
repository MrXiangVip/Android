
package com.wave;
public class PackageManagerService{


    public static PackageManagerService main(Context context, Installer installer,
            boolean factoryTest, boolean onlyCore) {
        // Self-check for initial settings.
//         PackageManagerServiceCompilerMapping.checkProperties();
//
        PackageManagerService m = new PackageManagerService(context, installer,
                factoryTest, onlyCore);
//         m.enableSystemUserPackages();
//         ServiceManager.addService("package", m);
//         final PackageManagerNative pmn = m.new PackageManagerNative();
//         ServiceManager.addService("package_native", pmn);
        return m;
    }

    public PackageManagerService(Context context, Installer installer,boolean factoryTest, boolean onlyCore) {

    }
}
