package com.example.concurrency.v1;

public class E01_HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println("Executed by thread: "+
                Thread.currentThread().getName());
    }
}
