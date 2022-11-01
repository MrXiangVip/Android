package com.wave.wm;

import com.wave.input.InputManagerService;
import com.wave.Context;
import com.wave.WindowManagerPolicy;

public class WindowManagerService {

    private static WindowManagerService sInstance;
    final InputManagerService mInputManager;
    final Context mContext;

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

}
