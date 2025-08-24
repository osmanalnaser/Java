package Threads;

class MultiThreading {
    public static void main(String[] args) {

        Thread[] threads = new Thread[5];


        for (int i = 0; i < 5; i++) {
            threads[i] = new CounterThread(i + 1);
            threads[i].start();
        }


        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fertig");
    }
}

class CounterThread extends Thread {
    private int threadNumber;
    private static int counter = 0;
    private static final Object lock = new Object();

    public CounterThread(int number) {
        this.threadNumber = number;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (counter >= 42) {
                    break;
                }
                counter++;
                System.out.println("Thread " + threadNumber + ": " + counter);
            }

            try {
                Thread.sleep(20); // Zeitintervall 20ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
