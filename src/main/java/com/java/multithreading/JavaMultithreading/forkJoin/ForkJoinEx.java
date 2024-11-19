package com.java.multithreading.JavaMultithreading.forkJoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FibonacciTask  extends RecursiveTask<Integer>{
        private final int n ;
        FibonacciTask(int n ){
            this.n =n;
        }
    @Override
    protected Integer compute() {
        if(n<=1) return n;

        FibonacciTask f1 = new FibonacciTask(n-1);
        FibonacciTask f2 =  new FibonacciTask(n-2);
//        f1.fork();
//        f2.fork();

        return f2.fork().join() + f1.fork().join();
    }
}
public class ForkJoinEx {


    public static void main(String[] args) {
        ForkJoinPool fork = new ForkJoinPool();
        System.out.println(fork.getActiveThreadCount());

        FibonacciTask obj = new FibonacciTask(10);

        System.out.println(fork.invoke(obj));
        System.out.println(fork.getActiveThreadCount());

    }
}
