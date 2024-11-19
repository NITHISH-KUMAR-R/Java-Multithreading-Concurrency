package com.JavaMultithreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;

public class FasterResponseEx {
    public static void main(String[] args) {
        CompletableFuture<Integer> response = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("Response 1");
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 1;
        });

        CompletableFuture<Integer> response2 = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("Response 2");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2;
        });

        CompletableFuture<Object> answer = CompletableFuture.anyOf(response2,response)
                .thenApplyAsync(result -> {
                    System.out.println(result);
                    return result;
                });

    answer.join();

    }
}
