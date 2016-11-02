package com.java7.threads.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class CallableFutureTest {
	
	private static final int THREAD_LIMIT = 5;
	
	@Test 
	public void callableFutureTest() {

         ExecutorService executor = Executors.newFixedThreadPool(THREAD_LIMIT);
         List<Future<Long>> list = new ArrayList<>();
         
         // 10 worker Threads of which only 5 will be active due to THREAD_LIMIT 
         for (int i = 0; i < 10; i++) {
                 Callable<Long> worker =  new CountCallable();
                 
                 //Runnable cannot return results so use Future
                 Future<Long> submit = executor.submit(worker);
                 
                 list.add(submit);
         }
         
         // now retrieve the result
         for (Future<Long> future : list) {
                 try {
                	
                		 System.out.println(future.get());
                	     
                 } catch (InterruptedException e) {
                         e.printStackTrace();
                 } catch (ExecutionException e) {
                         e.printStackTrace();
                 }
         }
         
         executor.shutdown();
 }

}
