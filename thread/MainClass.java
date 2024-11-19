package com.JavaMultithreading.thread;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main class starts now");
        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();
        Thread runnableDaemon = new Thread( new RunnableThread());
        runnableDaemon.setDaemon(true);
        daemonThread.setDaemon(true);


        userThread.start();
        daemonThread.start();
        runnableDaemon.start();

        Thread.getAllStackTraces().keySet().forEach(thread -> {
            String type = thread.isDaemon() ? "Daemon" : "User";
            System.out.println(thread.getName() + " - " + type);
        });

        System.out.println("Main Class endds now");



    }
}
