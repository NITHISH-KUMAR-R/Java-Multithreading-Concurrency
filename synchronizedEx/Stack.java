package com.JavaMultithreading.synchronizedEx;

public class Stack {

    private int capacity;
    private int arr[];
    private volatile int  stCounter;
    String lock1, lock2;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        stCounter = -1;
        lock1 = new String();
        lock2 = new String();

    }

    public int pop() {
        synchronized (lock1) {
            if (isEmpty()) return -1;
            int poppedElement = arr[stCounter];
            try {Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}
            arr[stCounter] = Integer.MIN_VALUE;
            stCounter--;

            return poppedElement;
        }

    }

    public int push(int element) {
        synchronized (lock1) {
            if (isFull()) return -1;
            stCounter++;
            try {Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}
            arr[stCounter] = element;
            return element;
        }

    }

    public boolean isEmpty() {
        return stCounter < 0;
    }


    public boolean isFull() {
        return stCounter >= arr.length - 1;
    }
}
