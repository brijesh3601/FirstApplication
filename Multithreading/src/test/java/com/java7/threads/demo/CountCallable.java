package com.java7.threads.demo;

import java.util.concurrent.Callable;

public class CountCallable implements Callable<Long>{
	
	@Override
	public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i < 10000; i++) {
                sum = i+1;
        }
        return sum;
}

}
