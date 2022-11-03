/*
 源码路径
 frameworks/base/core/java/android/os/Message.java
 */
package com.wave;

public final class Message  {

    public int what;

    /*package*/ Handler target;
    /*package*/ Runnable callback;
    void recycleUnchecked() {
        // Mark the message as in use while it remains in the recycled object pool.
        // Clear out all other details.

    }
}
