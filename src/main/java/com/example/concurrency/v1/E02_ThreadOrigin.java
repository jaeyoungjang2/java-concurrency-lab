package com.example.concurrency.v1;

public class E02_ThreadOrigin {
    public static void main(String[] args) {
        // Thread 클래스 상속
        Thread t1 = new ThreadByExtension("Worker-1");
        t1.start();

        // Runnable 인터페이스 구현
        Thread t2 = new Thread(new RunnableImplementation(), "Worker-2");
        t2.start();

        // 익명 내부 클래스 자바 1.1
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous: " + Thread.currentThread().getName());
            }}, "Worker-3"
        );
        t3.start();

        // 람다 (자바 8)
        Thread t4 = new Thread(() -> {
            System.out.println("Lmabda: " + Thread.currentThread().getName());
        }, "Worker-4");
        t4.start();


    }
}

// 방법1 Thread 클래스 상속
class ThreadByExtension extends Thread {
    public ThreadByExtension(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Extended thread: " + getName());
    }
}

// 방법2 Runnable interface 구현
class RunnableImplementation implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable: " + Thread.currentThread().getName());
    }
}