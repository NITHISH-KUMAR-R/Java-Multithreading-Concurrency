package com.java.multithreading.JavaMultithreading.sync;

public class Stack {
    private  int[] array;
    private   int stackTop;
    Object lock, lock2;

    public Stack(int capacity){
        array = new int[capacity];
        stackTop =-1;
        lock = new Object();
        lock2 = new Object();
    }

   // if we ar using in method level synchronized internally - it will be like
   // this(synchronized(this) - used as lock)
    public  boolean push(int element){
     synchronized (lock){
            if (isFull()) return false;
            ++stackTop;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            array[stackTop] = element;

            return true;
        }
    }
    public  int pop() {
        synchronized (lock){if (isEmpty()) return Integer.MIN_VALUE;
        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }

        stackTop--;
        return obj;
    }
    }
    public boolean isEmpty(){
        return stackTop < 0;
    }

    private boolean isFull() {
      return  stackTop >= array.length-1;
    }
}
