/*
 源码路径:
 frameworks/base/services/core/java/com/android/server/input/InputManagerService.java
 */
package com.wave.input;

import com.wave.Context;

public class InputManagerService {

    private final Context mContext;

    public InputManagerService(Context context) {
        this.mContext = context;

    }
    public void start() {
        System.out.println("Starting input manager");
    }
}