public class UserThreadDaemonThread {
    public static void main(String[] args) {
        // User thread example
        Thread userThread = new Thread(() -> {
            System.out.println("User thread starts and will sleep for 3 seconds...");
            try {
                Thread.sleep(3000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("User thread completes.");
        });

        // Daemon thread example
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running in background...");
                try {
                    Thread.sleep(1000); // Simulate background task
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("Main thread ends.");
    }
}
