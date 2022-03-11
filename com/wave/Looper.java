package com.wave;

import java.lang.ThreadLocal;

public final class Looper {


    private static final String TAG = "Looper";

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    final MessageQueue mQueue;

    static Thread mThread;

    private static Looper sMainLooper;  // guarded by Looper.class

    private Looper(boolean quitAllowed) {
        System.out.println("Looper 构造函数");

        mQueue = new MessageQueue( );
        mThread = Thread.currentThread();
    }

    public static  Looper myLooper() {
        System.out.println("myLooper");

        return sThreadLocal.get();
    }

    public static void prepareMainLooper() {
            System.out.println("prepareMainLooper");
            prepare(false);
            synchronized (Looper.class) {
                if (sMainLooper != null) {
                    throw new IllegalStateException("The main Looper has already been prepared.");
                }
                sMainLooper = myLooper();
            }
    }

    private static void prepare(boolean quitAllowed) {
        System.out.println("prepare");

        if (sThreadLocal.get() != null) {
                throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper(quitAllowed));
    }

    public static void loop() {
            System.out.println("loop");
            final Looper me = myLooper();
            if (me == null) {
                throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
            }
            final MessageQueue queue = me.mQueue;
            // Make sure the identity of this thread is that of the local process,
            // and keep track of what that identity token actually is.
            for (;;) {


                  synchronized(queue) {
                      while (queue.size() == 0) {
                          try {
                              System.out.println("wait here" );

                              queue.wait();
                          } catch (Exception e) {
                              System.out.println("wait error" + e.toString());

                          }
                      }
                      if (queue.size() > 0) {
                          System.out.println("处理消息"+ queue.size());
                          Message msg = queue.poll();
                          msg.target.dispatchMessage(msg);
                          System.out.println("处理完毕");
                      }
                  }
            }
    }
}
