package com.java.multithreading.JavaMultithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        int value = atomicInteger.getAndIncrement();
        boolean updated = atomicInteger.compareAndSet(1,10);
        System.out.println(value);
        int value2  = atomicInteger.get();
        System.out.println(value2);
        int value3 = atomicInteger.incrementAndGet();
        System.out.println(value3);

        System.out.println(updated);


    }
}
