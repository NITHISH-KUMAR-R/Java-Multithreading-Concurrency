package com.java.multithreading.JavaMultithreading.producerConsumer;

public class Producer implements   Runnable{
    private BlockingQueue blockingQueue;

    Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                blockingQueue.produce(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


 class Consumer implements  Runnable {
    private BlockingQueue blockingQueue;

     Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                blockingQueue.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
