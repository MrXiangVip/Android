/*
    xshx
    path: frameworks/base/core/java/com/android/internal/policy/DecorView.java
 */

package com.wave;
import com.wave.view.*;
import com.wave.Context;

public class DecorView extends FrameLayout {

    private PhoneWindow mWindow;

    DecorView(Context context, int featureId, PhoneWindow window, WindowManager.LayoutParams params) {
        System.out.println("DecorView");

    }

    void onResourcesLoaded(LayoutInflater inflater) {
        System.out.println("onResourcesLoaded");
    }

    void setWindow(PhoneWindow phoneWindow) {
        mWindow = phoneWindow;
//         Context context = getContext();
//         if (context instanceof DecorContext) {
//             DecorContext decorContext = (DecorContext) context;
//             decorContext.setPhoneWindow(mWindow);
//         }
    }
}
