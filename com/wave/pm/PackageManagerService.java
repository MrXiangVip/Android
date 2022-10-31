/*
    源码路径:
    frameworks/base/services/core/java/com/android/server/pm/PackageManagerService.java
 */
package com.wave.pm;

import java.io.File;
import java.util.HashMap;
import com.wave.Installer;
import com.wave.Context;
public class PackageManagerService {

    public Settings mSettings;

    private static final File sAppInstallDir = new File("./data", "app");

    final HashMap<String, PackageParser.Package> mPackages =
            new HashMap<String, PackageParser.Package>();

    final ParallelPackageParserCallback mParallelPackageParserCallback =
            new ParallelPackageParserCallback();

    class PackageParserCallback implements PackageParser.Callback {

        @Override
        public boolean hasFeature(String feature) {
            return false;
        }

        @Override
        public String[] getOverlayPaths(String targetPackageName, String targetPath) {
            return new String[0];
        }

        @Override
        public String[] getOverlayApks(String targetPackageName) {
            return new String[0];
        }
    }
    class ParallelPackageParserCallback extends PackageParserCallback {

    }

    public PackageManagerService(Context context, Installer installer,boolean factoryTest, boolean onlyCore) {
//     public PackageManagerService() {

        System.out.println("PackageManagerService");

        mSettings = new Settings();

        final int packageSettingCount = mSettings.mPackages.size();
        System.out.println("package count " + packageSettingCount);



        scanDirTracedLI(sAppInstallDir, 0, 0, 0);

    }
    public void systemReady() {
        System.out.println("PackageManagerService systemReady");
    }
//
    public static PackageManagerService main(Context context, Installer installer,   boolean factoryTest, boolean onlyCore) {
//     public static PackageManagerService main(String[] args) {

        System.out.println("启动 PackageManagerService");

        PackageManagerService m = new PackageManagerService(context, installer,factoryTest, onlyCore);
        return  m;
    }

    private void scanDirTracedLI(File scanDir, final int parseFlags, int scanFlags, long currentTime) {
        scanDirLI(scanDir, parseFlags, scanFlags, currentTime);

    }

    private void scanDirLI(File scanDir, int parseFlags, int scanFlags, long currentTime) {
        System.out.println("scanDirLI "+ scanDir.getAbsolutePath());
        final File[] files = scanDir.listFiles();
        try{
            int fileCount =0;
            ParallelPackageParser parallelPackageParser = new ParallelPackageParser(
                    mParallelPackageParserCallback);
            for( File file:files){
                boolean isPackage = PackageParser.isApkFile(file);
                if( !isPackage ){
                    continue;
                }
                parallelPackageParser.submit( file ,parseFlags);
                fileCount++;
                System.out.println("file count "+fileCount);
            }
        }catch (Exception e){

        }
    }


}