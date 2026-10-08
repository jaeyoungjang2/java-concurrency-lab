package com.example.concurrency.v1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class E04_MaxThread {
    public static void main(String[] args) {
        var threadCount = new AtomicInteger();
        try {
            while (true) {
                Thread t1 = new Thread(() -> {
                    threadCount.incrementAndGet();
                    // 쓰레드를 대기 상태로 유지
                    LockSupport.park();
                });
                t1.start();
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Reached thread limit: " + threadCount);
            e.printStackTrace();
        }
    }
}
