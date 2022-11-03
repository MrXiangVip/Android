/*
 源码路径
 frameworks/base/services/core/java/com/android/server/pm/Settings.java
 */
package com.wave.pm;

import java.io.File;
import java.util.HashMap;

public class Settings {
    private static final File DIR_ANDROID_DATA = new File("./data");
    private final File mSystemDir;
    private final File mSettingsFilename;

    final HashMap<String, PackageSetting> mPackages = new HashMap<>();
    Settings() {
        mSystemDir = new File(DIR_ANDROID_DATA, "system");
        mSystemDir.mkdirs();

        mSettingsFilename = new File(mSystemDir, "packages.xml");

    }
}
