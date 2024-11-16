package com.java.multithreading.JavaMultithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinter implements  Runnable{
    @Override
    public void run() {
            System.out.println(System.currentTimeMillis()+" hello world "+Thread.currentThread().getName());

    }
}
