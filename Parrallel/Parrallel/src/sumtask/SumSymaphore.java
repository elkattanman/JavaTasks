package sumtask;
import java.util.concurrent.*;
import java.util.concurrent.Semaphore;

public class SumSymaphore {
    static Semaphore sem = new Semaphore(1);//new
    static double sum = 0.0;
    final static int THREAD_COUNT = 1000;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        for (int th = 0; th < THREAD_COUNT; th++) {
            executor.execute(new Add(th));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("AllSum = " + (sum));
        System.out.println("Number of threads is " + THREAD_COUNT);
        System.out.println("Time with " + (endTime - startTime) + " milliseconds");
    }

    static class Add extends Thread {
        int threadRank;
        Add(int threadRank) {
            this.threadRank = threadRank;
        }
        public void run() {
            try {
                sem.acquire();
                try {
                    sum = sum + 1;
                } finally {
                    sem.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}