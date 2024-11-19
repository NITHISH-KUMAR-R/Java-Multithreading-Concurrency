package com.JavaMultithreading.executor;

public class NumberPrinter implements  Runnable{
    @Override
    public void run() {
            System.out.println(System.currentTimeMillis()+" hello world "+Thread.currentThread().getName());

    }
}
