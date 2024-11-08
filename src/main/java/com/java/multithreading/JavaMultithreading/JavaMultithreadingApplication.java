package com.java.multithreading.JavaMultithreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaMultithreadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMultithreadingApplication.class, args);

		System.out.println("Main is starting");
		Thread1 t1 = new Thread1();
		t1.start();
//		try{
//			t1.join();
//		}catch(InterruptedException e){
//			e.printStackTrace();
//
//		}


		Thread runThread = new Thread(new RunnableThread());
		runThread.start();

		Thread thread3 = new Thread(()->{
			for(int i =0;i<20;i++){
                try {
                    Thread.sleep(500);
					System.out.println("Lambda Thread " +Thread.currentThread());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

			}
		}, "thread3");

		thread3.start();

		System.out.println("Main is Ending ");

	}


}
