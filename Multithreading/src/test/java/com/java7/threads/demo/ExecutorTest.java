package com.java7.threads.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorTest {
	
	private static final int NTHREDS = 10;
	
	@Test
	public void runnableTest() throws InterruptedException {
		//no guarantee which thread will finish first.
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 10; i++) {
                Runnable worker = new CountRunnable(10);
                executor.submit(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        
        System.out.println("All threads done executing!!");
	}

}
