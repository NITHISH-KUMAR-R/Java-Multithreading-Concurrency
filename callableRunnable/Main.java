package com.JavaMultithreading.callableRunnable;

import java.util.concurrent.*;

public class Main {
    //Asynchronous Computation: The factorial calculation runs in the background, allowing the main thread to perform other tasks if needed.
    //Result Retrieval: The Future object is used to block and retrieve the result of the computation once it’s done.

    public static void main(String[] args) {
        ExecutorService thread = Executors.newSingleThreadExecutor();

        Callable<Long> factTask = () -> {
            long result = 1;
            for (int i = 1; i < 5; i++) {
                result *= i;
            }
            Thread.sleep(3000);
            return result;
        };

        Future<Long> asyncRun = thread.submit(factTask);

        try{
            System.out.println("Async factorial Running");
            Long result =asyncRun.get();
            System.out.println("Returning result: "+ result);

        }catch (InterruptedException | ExecutionException e){

        }finally {
            thread.shutdown();
        }


    }
}
