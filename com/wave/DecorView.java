/*
    xshx
    path: frameworks/base/core/java/com/android/internal/policy/DecorView.java
 */

package com.wave;
import com.wave.view.*;

public class DecorView extends FrameLayout {

    DecorView(int featureId, PhoneWindow window, WindowManager.LayoutParams params) {
        System.out.println("DecorView");
    }

    void onResourcesLoaded(LayoutInflater inflater) {
        System.out.println("onResourcesLoaded");
    }

}
