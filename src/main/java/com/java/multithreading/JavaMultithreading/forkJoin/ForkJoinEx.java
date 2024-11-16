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
        f1.fork();
        return f2.fork().join() + f1.join();
    }
}
public class ForkJoinEx {


    public static void main(String[] args) {
        ForkJoinPool fork = new ForkJoinPool();

        FibonacciTask obj = new FibonacciTask(10);
        System.out.println(fork.invoke(obj));
    }
}