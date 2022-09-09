
package com.wave;
public class PhoneWindow extends Window{

        public PhoneWindow(Context context, Window preservedWindow){
            System.out.println("PhoneWindow");
        }

        public void setContentView(int layoutResID) {
            System.out.println("setContentView"+layoutResID);

        }

        public void setContentView(View view) {
            System.out.println("setContentView"+view);
        }


}