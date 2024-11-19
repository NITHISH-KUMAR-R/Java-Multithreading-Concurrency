package com.JavaMultithreading.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);

        for(int i =1;i<5;i++){
            int taskId =i;
            ex.submit(()->{
            System.out.println("Thread name: "+Thread.currentThread().getName() +" Task ID "+taskId);});
        }
        ex.shutdown();
    }
}
