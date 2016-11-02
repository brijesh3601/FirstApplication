package com.java8.threads.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import org.junit.Test;

public class RecursiveActionTest {
	
	
	@Test
	public void testRecursiveAction(){
		
		ForkJoinPool pool = new ForkJoinPool();
		int [] data = {1,2,3,4,5};
		Square app = new Square(data, 0, data.length);
		pool.invoke(app);
		System.out.println(Square.result);
		
	}
	
	

}


class Square extends RecursiveAction {
	   /**
	 * 
	 */
	private static final long serialVersionUID = -3188727770251079765L;
	final int LIMIT = 3;
	   //keep static
	   static int result;
	   int start, end;
	   int[] data;
	   Square(int[] data, int start, int end) {
		   this.start = start;
		   this.end = end;
		   this.data = data;
	   }
	   @Override
	   protected void compute() {
		   if((end - start)< LIMIT){
			   for(int i= start;i<end;i++){
				   result+= data[i]*data[i];   
			   }
		   }else {
			 int mid = (start + end)/2;
			 Square left = new Square(data, start, mid); 
			 Square right = new Square(data, mid, end);
			 left.fork();
			 right.fork();
			 left.join();
			 right.join();
		   }
	   }
	 }