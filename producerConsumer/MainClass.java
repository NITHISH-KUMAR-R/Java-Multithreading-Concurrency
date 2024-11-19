package com.JavaMultithreading.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {
    public static void main(String[] args) {
//        SharedBuffer bq = new SharedBuffer();
//        Producer producer = new Producer(bq);
//        Consumer consumer = new Consumer(bq);
//        Thread producerThread = new Thread(producer);
//        producerThread.start();
//        Thread consumerThread = new Thread(consumer);
//        consumerThread.start();

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread prodBlock = new Thread(new Producer1(queue));
        Thread consBlock  = new Thread(new Consumer1(queue));
        prodBlock.start();
        consBlock.start();


    }
}
