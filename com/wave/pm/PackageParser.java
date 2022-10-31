package com.wave.pm;

import java.io.File;
import java.util.ArrayList;

public class PackageParser {

    public static final String APK_FILE_EXTENSION = ".apk";

    public final static class Package{

        public String packageName;
        public String manifestPackageName;
        public String codePath;

        public ApplicationInfo applicationInfo = new ApplicationInfo();

        public final ArrayList<Activity> activities = new ArrayList<Activity>(0);
        public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        public final ArrayList<Provider> providers = new ArrayList<Provider>(0);
        public final ArrayList<Service> services = new ArrayList<Service>(0);

        public Package(String packageName) {
            this.packageName = packageName;
            this.manifestPackageName = packageName;
//            applicationInfo.packageName = packageName;
//            applicationInfo.uid = -1;
        }
    }
    /**
     * Callback interface for retrieving information that may be needed while parsing
     * a package.
     */
    public interface Callback {
        boolean hasFeature(String feature);
        String[] getOverlayPaths(String targetPackageName, String targetPath);
        String[] getOverlayApks(String targetPackageName);
    }


    public final static class Provider {
        public final ProviderInfo info;

        public Provider(final ProviderInfo _info){
            info =_info;
        }

        public void setPackageName(String packageName) {
            info.packageName = packageName;
        }
    }

    public final static class Service {
        public final ServiceInfo info;

        public Service(final ServiceInfo _info){
            info =_info;
        }

        public void setPackageName(String packageName) {
            info.packageName = packageName;
        }
    }


    public final static class Activity {
        public final ActivityInfo info;
        public Activity( ActivityInfo _info){
            info =_info;
        }

    }

    public static final boolean isApkFile(File file) {
        return isApkPath(file.getName());
    }

    public static boolean isApkPath(String path) {
        return path.endsWith(APK_FILE_EXTENSION);
    }

    public Package parsePackage(File packageFile, int flags, boolean useCaches){

        System.out.println("parsePackage "+packageFile.getName());
        Package parsed =null;
        if (packageFile.isDirectory()) {
            parsed = parseClusterPackage(packageFile, flags);
        }else{
            parsed = parseMonolithicPackage(packageFile, flags);

        }
        return  parsed;
    }
    private Package parseClusterPackage(File packageDir, int flags) {
//        final PackageLite lite = parseClusterPackageLite(packageDir, 0);
        try{
            final File baseApk = new File("");
            final Package pkg = parseBaseApk( baseApk, flags);
            return  pkg;
        }catch (Exception e){

        }
        return  null;
    }
    public Package parseMonolithicPackage(File apkFile, int flags) {
        System.out.println("parseMonolithicPackage "+ apkFile.getAbsolutePath());
        try{
            final Package pkg = parseBaseApk(apkFile,  flags);
            return  pkg;
        }catch (Exception e){

        }
        return  null;
    }
    private Package parseBaseApk(File apkFile, int flags){
        System.out.println("parseBaseApk "+apkFile.getAbsolutePath());
        final String pkgName="";

        final Package pkg = new Package(pkgName);
        return  pkg;
    }

}
