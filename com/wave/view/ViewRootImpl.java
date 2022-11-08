/*
*  xshx
*  path: frameworks/base/core/java/android/view/ViewRootImpl.java
*/

package com.wave.view;

import com.wave.view.InputChannel;
import com.wave.Handler;
import com.wave.Message;
import com.wave.view.View.MeasureSpec;


public final class ViewRootImpl implements ViewParent{

    View mView;
    boolean mAdded;
    boolean mLayoutRequested;
    InputChannel mInputChannel;
    public boolean mTraversalScheduled;
    int mWidth;
    int mHeight;
    public final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();

    Choreographer mChoreographer;

    final class TraversalRunnable implements Runnable {
        @Override
        public void run() {
            doTraversal();
        }
    }
    final TraversalRunnable mTraversalRunnable = new TraversalRunnable();


    final class ViewRootHandler extends Handler {
        public void handleMessage(Message msg) {
            System.out.println("handleMessage");
        }
    }
    final ViewRootHandler mHandler = new ViewRootHandler();

    public ViewRootImpl( ) {
        System.out.println("ViewRootImpl 构造函数");
        mAdded = false;

    }

    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        System.out.println("ViewRootImpl setView");
        if( mView == null ){
            mView = view;

            mAdded = true;
            requestLayout();
            mInputChannel = new InputChannel();
//          此处会调到wms 的addWindow

        }
    }

    public void requestLayout() {
            mLayoutRequested = true;
            scheduleTraversals();
    }
    void scheduleTraversals() {
        if (!mTraversalScheduled) {
            mTraversalScheduled = true;
//             mTraversalBarrier = mHandler.getLooper().getQueue().postSyncBarrier();
            mChoreographer.postCallback(
                    Choreographer.CALLBACK_TRAVERSAL, mTraversalRunnable, null);

        }
    }

    void doTraversal() {
        if (mTraversalScheduled) {
            mTraversalScheduled = false;
//             mHandler.getLooper().getQueue().removeSyncBarrier(mTraversalBarrier);

//             if (mProfile) {
//                 Debug.startMethodTracing("ViewAncestor");
//             }

            performTraversals();

//             if (mProfile) {
//                 Debug.stopMethodTracing();
//                 mProfile = false;
//             }
        }
    }

    private void performTraversals() {
        System.out.println("performTraversals");
        WindowManager.LayoutParams lp = mWindowAttributes;

        int childWidthMeasureSpec = getRootMeasureSpec(mWidth, lp.width);
        int childHeightMeasureSpec = getRootMeasureSpec(mHeight, lp.height);
        performMeasure(childWidthMeasureSpec, childHeightMeasureSpec);

        performLayout(lp, mWidth, mHeight);

        performDraw();

    }


    /**
     * Figures out the measure spec for the root view in a window based on it's
     * layout params.
     *
     * @param windowSize
     *            The available width or height of the window
     *
     * @param rootDimension
     *            The layout params for one dimension (width or height) of the
     *            window.
     *
     * @return The measure spec to use to measure the root view.
     */
    private static int getRootMeasureSpec(int windowSize, int rootDimension) {
        int measureSpec;
        switch (rootDimension) {

            case ViewGroup.LayoutParams.MATCH_PARENT:
                // Window can't resize. Force root view to be windowSize.
                measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
                break;
            case ViewGroup.LayoutParams.WRAP_CONTENT:
                // Window can resize. Set max size for root view.
                measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
                break;
            default:
                // Window wants to be an exact size. Force root view to be that size.
                measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
                break;
        }
        return measureSpec;
    }

    private void performMeasure(int childWidthMeasureSpec, int childHeightMeasureSpec) {
        if (mView == null) {
            return;
        }
        try {
            mView.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        } finally {
            System.out.println("measure over ");
        }
    }
    private void performLayout(WindowManager.LayoutParams lp, int desiredWindowWidth,
            int desiredWindowHeight) {
        System.out.println("performLayout");
    }

    private void performDraw() {
        System.out.println("performDraw");
    }
}

