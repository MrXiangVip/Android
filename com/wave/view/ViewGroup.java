/*
* 源码路径
* frameworks/base/core/java/android/view/ViewGroup.java
*/
package com.wave.view;
public abstract class ViewGroup extends View implements  ViewManager {

    public static class LayoutParams {
        /**
         * Special value for the height or width requested by a View.
         * FILL_PARENT means that the view wants to be as big as its parent,
         * minus the parent's padding, if any. This value is deprecated
         * starting in API Level 8 and replaced by {@link #MATCH_PARENT}.
         */
        public static final int FILL_PARENT = -1;

        /**
         * Special value for the height or width requested by a View.
         * MATCH_PARENT means that the view wants to be as big as its parent,
         * minus the parent's padding, if any. Introduced in API Level 8.
         */
        public static final int MATCH_PARENT = -1;

        /**
         * Special value for the height or width requested by a View.
         * WRAP_CONTENT means that the view wants to be just large enough to fit
         * its own internal content, taking its own padding into account.
         */
        public static final int WRAP_CONTENT = -2;

        public int width;
        public int height;

        public LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }


    public void addView(View view, ViewGroup.LayoutParams params){
            System.out.println("addView");

    }
    public void updateViewLayout(View view, ViewGroup.LayoutParams params){
            System.out.println("updateViewLayout");

    }
    public void removeView(View view){
            System.out.println("removeView");
    }

}