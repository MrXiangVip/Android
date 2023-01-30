/*
 源码路径
 frameworks/base/core/java/android/content/Intent.java
 */
package com.wave;
public class Intent {

    private String mAction;
//     private Uri mData;
    private String mType;
    private String mIdentifier;
    private String mPackage;
//     private ComponentName mComponent;
    private int mFlags;
//     private ArraySet<String> mCategories;
//     private Bundle mExtras;
//     private Rect mSourceBounds;
    private Intent mSelector;
//     private ClipData mClipData;
//     private int mContentUserHint = UserHandle.USER_CURRENT;
    /** Token to track instant app launches. Local only; do not copy cross-process. */
    private String mLaunchToken;
}