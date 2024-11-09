package com.java.multithreading.JavaMultithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int MAX_CAPACITY = 2;

    public synchronized  void produce(int data) throws InterruptedException {
        if(queue.size() == MAX_CAPACITY){
            System.out.println("waiting for consume some data");
            wait();
        }
        queue.add(data);
        System.out.println("Produce value: "+data);
        notify();
    }

    public synchronized  int consume() throws InterruptedException {
        if(queue.isEmpty()){
            System.out.println("waitinng for produce some data");
            wait();
        }
        int data = queue.poll();
        System.out.println("Consume Value: "+data);
        notify();
        return data;
    }
}
