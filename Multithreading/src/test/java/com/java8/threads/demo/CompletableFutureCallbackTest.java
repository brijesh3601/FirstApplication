package com.java8.threads.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class CompletableFutureCallbackTest {
        
	@Test
	public void testCompletableFutureCallback() {
                long started = System.currentTimeMillis();

                /*
                 * CompletableFuture supports both blocking & non-blocking approach
                 * */
                CompletableFuture<String>  data = createCompletableFuture()
                            .thenApply((Integer count) -> {
                                int transformedValue = count * 10;
                                return transformedValue;
                            }).thenApply(transformed -> "Finally creates a string: " + transformed);

                        try {
                            System.out.println(data.get());
                        } catch (InterruptedException | ExecutionException e) {

                        }
        }

        public static CompletableFuture<Integer> createCompletableFuture() {
                CompletableFuture<Integer>  result = CompletableFuture.supplyAsync(() -> {
                try {
                    // simulate long running task
                    Thread.sleep(5000);
                } catch (InterruptedException e) { }
                return 20;
            });
                return result;
        }

}