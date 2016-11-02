package com.java7.threads.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RunnableTest {
	
	
	@Test
	public void basicThreadTest(){
		

		 List<Thread> threads = new ArrayList<Thread>();
        //create 10 threads
        for (int i = 0; i < 10; i++) {
                Runnable task = new CountRunnable(1000);
                Thread worker = new Thread(task);
                //set the name of the thread
                worker.setName("Thread-" + i);
                // Start the thread, never call method run() direct
                worker.start();
                // Remember the thread for later usage
                threads.add(worker);
        }
        int running = 0;
        do {
                running = 0;
                for (Thread thread : threads) {
                        if (thread.isAlive()) {
                                running++;
                        }
                }
                
                System.out.println("Total thread running = " + running);
        } while (running > 0);
	
		
	}

}
