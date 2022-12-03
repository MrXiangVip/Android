/*

 frameworks/base/graphics/java/android/graphics/Rect.java
 */

package com.wave.graphics;

import java.lang.StringBuilder;

public final class Rect  {
    public int left;
    public int top;
    public int right;
    public int bottom;


    public Rect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public Rect( Rect r) {
        if (r == null) {
            left = top = right = bottom = 0;
        } else {
            left = r.left;
            top = r.top;
            right = r.right;
            bottom = r.bottom;
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Rect("); sb.append(left); sb.append(", ");
        sb.append(top); sb.append(" - "); sb.append(right);
        sb.append(", "); sb.append(bottom); sb.append(")");
        return sb.toString();
    }

    public void set(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void set( Rect src) {
        this.left = src.left;
        this.top = src.top;
        this.right = src.right;
        this.bottom = src.bottom;
    }

}
