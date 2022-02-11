package com.android;

public final class ActivityThread {


        static volatile Handler sMainThreadHandler;  // set once in main()
        final H mH = new H();

        final Handler getHandler() {
            System.out.println("getHandler");
            return mH;
        }

        public static void main(String[] args) {

            Looper.prepareMainLooper();

            ActivityThread thread = new ActivityThread();

            if (sMainThreadHandler == null) {
                sMainThreadHandler = thread.getHandler();
            }
            Looper.loop();
        }


        class H extends Handler {

            public void handleMessage(Message msg) {
                System.out.println("msg "+msg.what);
            }
        }

        ActivityThread() {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count =0;
                    while(count <10){

                        System.out.println("构建message"+count);
                        Message msg = new Message();
                        msg.what = count;
                        mH.sendMessage( msg );

                        count++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
            thread.start();
        }

}
