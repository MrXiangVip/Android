package com.wave;

class ZygoteServer {
    public static final String TAG = "ZygoteServer";


    ZygoteServer() {
    }

    void  runSelectLoop(String abiList) {
         System.out.println("runSelectLoop "+abiList);
         while (true) {
            try{
                Thread.sleep(1);
            }catch(Exception e){
                 System.out.println("error "+e.toString());
            }
         }
    }
}