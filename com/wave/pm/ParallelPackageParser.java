/*
 源码路径
 frameworks/base/services/core/java/com/android/server/pm/ParallelPackageParser.java
 */
package com.wave.pm;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelPackageParser {
    private static final int MAX_THREADS = 4;
    private static final int QUEUE_CAPACITY = 10;

    private final BlockingQueue<ParseResult> mQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private final PackageParser.Callback mPackageParserCallback;

    private final ExecutorService mService = Executors.newFixedThreadPool(MAX_THREADS,
            new ThreadFactory() {
                private final AtomicInteger threadNum = new AtomicInteger(0);

                @Override
                public Thread newThread(final Runnable r) {
                    return new Thread("package-parsing-thread" + threadNum.incrementAndGet()) {
                        @Override
                        public void run() {
//                            Process.setThreadPriority(linuxThreadPriority);
                            r.run();
                        }
                    };
                }
            });

    ParallelPackageParser( PackageParser.Callback callback) {

        mPackageParserCallback = callback;
    }

    static class ParseResult {

        PackageParser.Package pkg; // Parsed package
        File scanFile; // File that was parsed
        Throwable throwable; // Set if an error occurs during parsing

        @Override
        public String toString() {
            return "ParseResult{" +
                    "pkg=" + pkg +
                    ", scanFile=" + scanFile +
                    ", throwable=" + throwable +
                    '}';
        }
    }

    public void submit(File scanFile, int parseFlags) {

        mService.submit(() -> {
            System.out.println(""+ Thread.currentThread().toString());
            ParseResult  pr = new ParseResult();
            try {
                PackageParser pp = new PackageParser();

                pr.pkg = parsePackage(pp, scanFile, parseFlags);
            }catch (Exception e){

            }finally {

            }

            try{
                mQueue.put( pr);
                System.out.println("inQueue");
            }catch (Exception e){

            }
        });
    }

    protected PackageParser.Package parsePackage(PackageParser packageParser, File scanFile,
                                                 int parseFlags)  {
        return packageParser.parsePackage(scanFile, parseFlags, true /* useCaches */);
    }

}
