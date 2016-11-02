package com.java8.threads.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureBasicTest {

	public void testCompletableFutureBasic() {
		long started = System.currentTimeMillis();

		// configure CompletableFuture
		CompletableFuture<Integer> futureCount = createCompletableFuture();

		// continue to do other work
		System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");

		// now its time to get the result
		try {
			int count = futureCount.get();
			System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds");

			System.out.println("Result " + count);
		} catch (InterruptedException | ExecutionException ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}

	private static CompletableFuture<Integer> createCompletableFuture() {
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(new Supplier<Integer>() {
			public Integer get() {
				{
					try {
						// simulate long running task
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
					return 20;
				}
			}
		});

		return futureCount;
	}

}