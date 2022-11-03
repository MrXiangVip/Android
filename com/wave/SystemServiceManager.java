/*
 源码路径
 frameworks/base/services/core/java/com/android/server/SystemServiceManager.java
 */


package com.wave;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SystemServiceManager {
    private static final String TAG = "SystemServiceManager";

    public <T extends SystemService> T startService(Class<T> serviceClass) {
            try {
                final String name = serviceClass.getName();
                System.out.println("Starting " + name);

                // Create the service.
                if (!SystemService.class.isAssignableFrom(serviceClass)) {
                    throw new RuntimeException("Failed to create " + name
                            + ": service must extend " + SystemService.class.getName());
                }
                final T service;
                try {
                    Constructor<T> constructor = serviceClass.getConstructor();
                    service = constructor.newInstance( );
                } catch (InstantiationException ex) {
                    throw new RuntimeException("Failed to create service " + name
                            + ": service could not be instantiated", ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException("Failed to create service " + name
                            + ": service must have a public constructor with a Context argument", ex);
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException("Failed to create service " + name
                            + ": service must have a public constructor with a Context argument", ex);
                } catch (InvocationTargetException ex) {
                    throw new RuntimeException("Failed to create service " + name
                            + ": service constructor threw an exception", ex);
                }

                startService(service);
                return service;
            }
            finally {
//                 Trace.traceEnd(Trace.TRACE_TAG_SYSTEM_SERVER);
                System.out.println("finally");
            }
    }



    public void startService( final SystemService service) {
            // Register it.
//             mServices.add(service);
            // Start it.
            try {
                service.onStart();
            } catch (RuntimeException ex) {
                throw new RuntimeException("Failed to start service " + service.getClass().getName()
                        + ": onStart threw an exception", ex);
            }
    }
}