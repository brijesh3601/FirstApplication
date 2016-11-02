package com.java8.threads.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorTest {

	private static final int NTHREDS = 10;

	@Test
	public void runnableTest() throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);

		for (int j = 0; j < 10; j++) {
			int countUntil = 10;
			executor.submit(() -> {

				long sum = 0;
				for (long i = 1; i < countUntil; i++) {
					sum = i + 1;
				}
				System.out.println(Thread.currentThread().getName() + " total = " + sum);
			});
		}
		
		//this will make executor stop accepting new threads 
		executor.shutdown();
		
		//wait till all threads execute summing up values.
		executor.awaitTermination(1000L, TimeUnit.MILLISECONDS);
		
		System.out.println("All threads done executing!!");
	}

}
