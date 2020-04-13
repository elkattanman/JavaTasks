package FactorialTask;

import java.util.concurrent.*;

public class Factorial {

    final static int THREAD_COUNT = 3;
    static int n = 6;

    static double fact = 1.0;

    //static int max = 0;
    public static void main(String[] args) {

        
        ExecutorService executor = Executors.newCachedThreadPool();

        long startTime = System.currentTimeMillis();
        for (int th = 0; th < THREAD_COUNT; th++) {
            executor.execute(new Fact(th));
        }
        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();

        //result almost incorrect with out Synchronization
        System.out.println("fact = " + (fact));
        System.out.println("Number of threads is " + THREAD_COUNT);
        System.out.println("Time with " + (endTime - startTime) + " milliseconds");
    }

    static class Fact implements Runnable {

        int threadRank;

        Fact(int threadRank) {
            this.threadRank = threadRank;
        }

        public void run() {
            threadSum(threadRank);
        }

        void threadSum(int threadRank) {
            // double factor=1;
            int my_n = n / THREAD_COUNT;
            int my_first_i = my_n * threadRank;
            int first = my_first_i + 1;
            int my_last_i = my_first_i + my_n;

            for (int i = first; i <= my_last_i; i++) {
                fact = fact * i;
            }

        }

    }
}
