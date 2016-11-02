package com.java7.threads.demo;

public class CountRunnable implements Runnable {
    private final long countUntil;

    CountRunnable(long countUntil) {
            this.countUntil = countUntil;
    }

    //Runnable interface cannot return results so use Future
    public void run() {
            long sum = 0;
            for (long i = 1; i < countUntil; i++) {
                    sum =i+1;
            }
            System.out.println(Thread.currentThread().getName()+" total = " + sum);
    }
}