package com.java.multithreading.JavaMultithreading.volatileEx;

public class Singleton {
  private static volatile Singleton singletonInstance = null;
//    The volatile keyword ensures that the singletonInstance variable is not cached,
//    making sure that every thread reads the latest value of singletonInstance directly from memory.
//    This is essential in multithreaded scenarios to prevent multiple threads from creating separate instances.

    private Singleton(){
        System.out.println("Singleton Instace");
    }

    public   void message(){
        System.out.println("SingletonMethod");
    }

    public   static Singleton getInstance(){
        if(singletonInstance ==null){
            synchronized (Singleton.class){
                if (singletonInstance ==null){
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }





}
