package com.java.multithreading.JavaMultithreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->{
            System.out.println();
            return  "data";
        }).thenApply((data)->{
            return data.toUpperCase();
        }).thenAccept((data)->{
            System.out.println("Final result: "+data);
            System.out.println("Length result: ");
        });

        CompletableFuture<Integer> supply = CompletableFuture.supplyAsync(()->10);

        CompletableFuture<Integer> ans = supply.thenApplyAsync(result -> result * 20).thenApplyAsync(result->result+5);

                                    ans.thenAccept(result -> System.out.println(result));
    }
}
