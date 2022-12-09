/*
frameworks/base/core/java/android/content/res/Configuration.java
 */
package com.wave.res;

public final class Configuration  {

    public static final Configuration EMPTY = new Configuration();
    private static final String TAG = "Configuration";

    public float fontScale;


    public int orientation;
    /** Constant for {@link #orientation}: a value indicating that no value has been set. */
    public static final int ORIENTATION_UNDEFINED = 0;
    /** Constant for {@link #orientation}, value corresponding to the
     * <a href="{@docRoot}guide/topics/resources/providing-resources.html#OrientationQualifier">port</a>
     * resource qualifier. */
    public static final int ORIENTATION_PORTRAIT = 1;
    /** Constant for {@link #orientation}, value corresponding to the
     * <a href="{@docRoot}guide/topics/resources/providing-resources.html#OrientationQualifier">land</a>
     * resource qualifier. */
    public static final int ORIENTATION_LANDSCAPE = 2;
    /** deprecated Not currently supported or used. */
    public static final int ORIENTATION_SQUARE = 3;

    /**
     * Overall orientation of the screen.  May be one of
     * {@link #ORIENTATION_LANDSCAPE}, {@link #ORIENTATION_PORTRAIT}.
     */

    public int screenWidthDp;
    public static final int SCREEN_WIDTH_DP_UNDEFINED = 0;

    public int screenHeightDp;
    public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0;

    public int densityDpi;
    public static final int DENSITY_DPI_UNDEFINED = 0;



    public Configuration() {
        unset();
    }

    public Configuration(Configuration o) {
        setTo(o);
    }

    public void unset() {
        setToDefaults();
        fontScale = 0;
    }

    public void setToDefaults() {
        fontScale = 1;
        orientation = ORIENTATION_UNDEFINED;
        screenWidthDp  = SCREEN_WIDTH_DP_UNDEFINED;
        screenHeightDp  = SCREEN_HEIGHT_DP_UNDEFINED;
        densityDpi = DENSITY_DPI_UNDEFINED;

    }

    public void setTo(Configuration o) {
        fontScale = o.fontScale;
        orientation = o.orientation;
        screenWidthDp = o.screenWidthDp;
        screenHeightDp = o.screenHeightDp;
        densityDpi = o.densityDpi;

    }
}