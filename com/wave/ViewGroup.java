/*
* xshx
* path: frameworks/base/core/java/android/view/ViewGroup.java
*/
package com.wave;
public abstract class ViewGroup extends View implements  ViewManager {

    public static class LayoutParams {

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