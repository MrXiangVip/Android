package com.wave;

public class FregService{

    private int mPtr=0;
    public FregService(){
			System.out.println("Hello, FregService");
            mPtr = init_native();
            if( mPtr ==0 ){
                System.out.println("init failed");
            }
    }

    public void setValue( int value ){
        if( mPtr ==0 ){
            System.out.println("init maybe failed");
            return;
        }
        setValue_native(mPtr, value);
    }

    public int getValue( ){
        if( mPtr ==0 ){
            System.out.println("init maybe failed");
            return 0;
        }
        return getValue_native(mPtr);
    }

    native private static  int init_native();
    native private static  void setValue_native(int ptr, int value);
    native private static  int getValue_native( int ptr );

}