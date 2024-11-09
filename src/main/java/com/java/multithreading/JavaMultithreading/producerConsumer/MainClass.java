package com.java.multithreading.JavaMultithreading.producerConsumer;

public class MainClass {
    public static void main(String[] args) {
        BlockingQueue bq = new BlockingQueue();
        Producer producer = new Producer(bq);
        Consumer consumer = new Consumer(bq);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();


    }
}
