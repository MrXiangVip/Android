/*
 源码路径
 frameworks/base/core/java/android/view/View.java
 */
package com.wave.view;

public class View{
    public static final int NO_ID = -1;
    int mID = NO_ID;

//     public View(Context context) {
    public View() {
        System.out.println("View");
    }

    public final <T extends View> T findViewById(int id) {
        if (id == NO_ID) {
            return null;
        }
        return findViewTraversal(id);
    }

    protected <T extends View> T findViewTraversal(int id) {
        if (id == mID) {
            return (T) this;
        }
        return null;
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        System.out.println("setLayoutParams");
    }
}