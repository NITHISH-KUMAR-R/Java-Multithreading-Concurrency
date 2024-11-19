package com.JavaMultithreading.forkJoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//ForkJoinPool is designed for parallel processing by breaking tasks into smaller pieces using the fork/join framework.
//RecursiveTask is a subclass of ForkJoinTask used to define tasks that return a result.
//Fork compute join methods are there

//Use fork():
//When you want the task to execute in parallel and utilize multiple threads.
//Use compute():
//When the task is simple enough or already in a parallel context, and delegating it to another thread is unnecessary.

class FibonacciTask  extends RecursiveTask<Integer>{
        private final int n ;
        FibonacciTask(int n ){
            this.n =n;
        }
    @Override
    protected Integer compute() {
        if(n<=1) return n;

        FibonacciTask f1 = new FibonacciTask(n-1);
        f1.fork();
        FibonacciTask f2 =  new FibonacciTask(n-2);
        //f2.compute();

        return f2.compute() + f1.join();
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


