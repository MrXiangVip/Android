
package com.wave;
import com.wave.ActivityThread;
class ContextImpl extends Context {

    private ContextImpl(){

    }

    static ContextImpl createSystemContext(ActivityThread mainThread) {
//         LoadedApk packageInfo = new LoadedApk(mainThread);
//         ContextImpl context = new ContextImpl(null, mainThread, packageInfo, null, null, null, 0,
//                 null);
//         context.setResources(packageInfo.getResources());
//         context.mResources.updateConfiguration(context.mResourcesManager.getConfiguration(),
//                 context.mResourcesManager.getDisplayMetrics());
//         return context;

            ContextImpl  context = new ContextImpl();
            return context;
    }
}