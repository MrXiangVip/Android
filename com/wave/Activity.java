

package com.wave;

// public class Activity extends ContextThemeWrapper{
public class Activity{


    public void startActivity(String className){
        System.out.println("startActivity "+className);

    }

    protected void onCreate( ) {
        System.out.println("startActivity ");
    }
}
