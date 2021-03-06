package sumtask;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class SumLock {
    final static int THREAD_COUNT = 1000;
    static double sum = 0.0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        for (int th = 0; th < THREAD_COUNT; th++) {
            executor.execute(new Add(th));
        }
        executor.shutdown();
        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("AllSum = " + (sum));
        System.out.println("Number of threads is " + THREAD_COUNT);
        System.out.println("Time with " + (endTime - startTime) + " milliseconds");
    }

    static class Add implements Runnable {

        int threadRank;
        private static Lock lock = new ReentrantLock();

        Add(int threadRank) {
            this.threadRank = threadRank;
        }

        public void run() {
            threadSum(threadRank);
        }
        void threadSum(int threadRank) {
            lock.lock();
            sum = sum + 1;
            lock.unlock(); // Release the lock
        }
    }
}