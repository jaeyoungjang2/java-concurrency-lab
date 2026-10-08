package com.example.concurrency.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E03_Executor {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                executor.submit(() -> {
                    System.out.println("Executing task " + taskId +
                            " in thread" + Thread.currentThread().getName());
                });
            }
        }
    }
}
