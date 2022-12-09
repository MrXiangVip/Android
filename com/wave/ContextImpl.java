/*
 源码路径
 frameworks/base/core/java/android/app/ContextImpl.java
 */
package com.wave;
import com.wave.ActivityThread;
class ContextImpl extends Context {

    private Context mOuterContext;
    final  ActivityThread mMainThread;
    final  String mClassName;

//
    private ContextImpl( ContextImpl container,  ActivityThread mainThread, String className){
        mOuterContext = this;
        mMainThread = mainThread;
        mClassName = className;
    }

    static ContextImpl createSystemContext(ActivityThread mainThread) {
//         LoadedApk packageInfo = new LoadedApk(mainThread);
//         ContextImpl context = new ContextImpl(null, mainThread, packageInfo, null, null, null, 0,
//                 null);
//         context.setResources(packageInfo.getResources());
//         context.mResources.updateConfiguration(context.mResourcesManager.getConfiguration(),
//                 context.mResourcesManager.getDisplayMetrics());
//         return context;

            ContextImpl  context = new ContextImpl(null, mainThread,null);
            return context;
    }


    static ContextImpl createActivityContext(ActivityThread mainThread, String className) {
        System.out.println("createActivityContext");
        ContextImpl  context = new ContextImpl( null, mainThread, className);
        return context;
    }
}