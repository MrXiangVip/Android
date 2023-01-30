/*
    xshx
    path: frameworks/base/core/java/com/android/internal/policy/DecorView.java
 */

package com.wave;
import com.wave.view.*;
import com.wave.Context;
import static com.wave.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class DecorView extends FrameLayout {

    private PhoneWindow mWindow;
    ViewGroup mContentRoot;

    DecorView(Context context, int featureId, PhoneWindow window, WindowManager.LayoutParams params) {
        super(context);
        System.out.println("DecorView");
        setWindow( window );
    }

    void onResourcesLoaded(LayoutInflater inflater, int layoutResource) {
        System.out.println("onResourcesLoaded");
        final View root = inflater.inflate(layoutResource, null );
        addView( root, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
        mContentRoot = (ViewGroup) root;

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
