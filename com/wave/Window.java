package com.wave;

public abstract class Window {

//     public abstract void setContentView(View view, ViewGroup.LayoutParams params);

//     public abstract @NonNull View getDecorView();

    public abstract void setContentView(int layoutResID);

    public abstract void setContentView(View view);

    public void setWindowManager(){
        System.out.println("setWindowManager");
    }
}
