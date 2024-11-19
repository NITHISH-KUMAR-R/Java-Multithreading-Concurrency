package com.JavaMultithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(5);
        NumberPrinter  task = new NumberPrinter();


        for(int i =1;i<100;i++){
            if(i==10 | i==50 | i==99){
                System.out.println("Checking");
            }
            System.out.println("Name of Thread "+ Thread.currentThread().getName() + i);
            threadpool.submit(task);
        }

        threadpool.shutdown();
        System.out.println("Main Thread finished");
    }
}
