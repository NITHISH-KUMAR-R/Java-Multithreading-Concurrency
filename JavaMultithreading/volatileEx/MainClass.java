package com.java.multithreading.JavaMultithreading.volatileEx;

public class MainClass {
    public static void main(String[] args) {
      Singleton sc = Singleton.getInstance();
      sc.message();
        Singleton sc2 = Singleton.getInstance();
        sc2.message();

    }
}
