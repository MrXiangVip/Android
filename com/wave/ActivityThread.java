
package com.wave;

import com.wave.ContextImpl;
public final class ActivityThread  {


    private ContextImpl mSystemContext;

    public static ActivityThread systemMain() {
        // The system process on low-memory devices do not get to use hardware
        // accelerated drawing, since this can add too much overhead to the
        // process.
        ActivityThread thread = new ActivityThread();
//         thread.attach(true, 0);
        return thread;
    }

    ActivityThread() {
//             mResourcesManager = ResourcesManager.getInstance();
    }


    public ContextImpl getSystemContext() {
        synchronized (this) {
            if (mSystemContext == null) {
                mSystemContext = ContextImpl.createSystemContext(this);
            }
            return mSystemContext;
        }
    }

}