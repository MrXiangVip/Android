/*
 * 源码路径：
 *frameworks/base/services/core/java/com/android/server/wm/WindowManagerService.java
 */
package com.wave.wm;

import com.wave.input.InputManagerService;
import com.wave.Context;
import com.wave.WindowManagerPolicy;
import static com.wave.view.WindowManager.LayoutParams.FIRST_SUB_WINDOW;
import static com.wave.view.WindowManager.LayoutParams.LAST_SUB_WINDOW;
import com.wave.view.WindowManager.LayoutParams;
import com.wave.graphics.Rect;

public class WindowManagerService {

    private static WindowManagerService sInstance;
    final InputManagerService mInputManager;
    final Context mContext;
    final WindowHashMap mWindowMap = new WindowHashMap();

    public static WindowManagerService main(final Context context, final InputManagerService im,
                                                final boolean haveInputMethods, final boolean showBootMsgs,
                                                    final boolean onlyCore, WindowManagerPolicy policy ){

        sInstance = new WindowManagerService(context, im, haveInputMethods, showBootMsgs,onlyCore, policy);
        return sInstance;
    }

    private WindowManagerService(Context context, InputManagerService inputManager,
                                    boolean haveInputMethods, boolean showBootMsgs,
                                        boolean onlyCore, WindowManagerPolicy policy){
        mContext = context;
        mInputManager = inputManager; // Must be before createDisplayContentLocked.


    }
//     public int addWindow(Session session, IWindow client, int seq,
//             LayoutParams attrs, int viewVisibility, int displayId, Rect outFrame,
//             Rect outContentInsets, Rect outStableInsets, Rect outOutsets,
//             DisplayCutout.ParcelableWrapper outDisplayCutout, InputChannel outInputChannel)
    public int addWindow(LayoutParams attrs , Rect outFrame){
        System.out.println("addWindow");
        int res =0;
        final int type = attrs.type;
        synchronized(mWindowMap) {

            if (type >= FIRST_SUB_WINDOW && type <= LAST_SUB_WINDOW) {
                System.out.println("type " + type);
            }
        }

//         final WindowState win = new WindowState(this, session, client, token, parentWindow,
//                     appOp[0], seq, attrs, viewVisibility, session.mUid,
//                     session.mCanAddInternalSystemWindow);

        return res;
    }



}
