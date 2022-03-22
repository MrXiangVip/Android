
package com.wave;
public class ContextWrapper extends Context {

    Context mBase;

    public ContextWrapper(Context base) {
        mBase = base;
    }

}
