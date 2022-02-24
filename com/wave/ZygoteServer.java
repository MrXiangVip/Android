package com.wave;

class ZygoteServer {
    public static final String TAG = "ZygoteServer";


    ZygoteServer() {
    }
    void registerServerSocketFromEnv(String socketName) {
           System.out.println("registerServerSocketFromEnv "+socketName);

//         if (mServerSocket == null) {
//             int fileDesc;
//             final String fullSocketName = ANDROID_SOCKET_PREFIX + socketName;
//             try {
//                 String env = System.getenv(fullSocketName);
//                 fileDesc = Integer.parseInt(env);
//             } catch (RuntimeException ex) {
//                 throw new RuntimeException(fullSocketName + " unset or invalid", ex);
//             }
//
//             try {
//                 FileDescriptor fd = new FileDescriptor();
//                 fd.setInt$(fileDesc);
//                 mServerSocket = new LocalServerSocket(fd);
//                 mCloseSocketFd = true;
//             } catch (IOException ex) {
//                 throw new RuntimeException(
//                         "Error binding to local socket '" + fileDesc + "'", ex);
//             }
//         }
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