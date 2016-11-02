package com.java7.threads.demo;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	
	//this class shows non blocking way to increment counter
	//instead of synchronized block compare-and-swap(CAS) operation is used
	//CAS operated at low level atomic hardware primitives that checks for certain value & if it has value it will perform operation 
	  private AtomicInteger value = new AtomicInteger();
      public int getValue(){
              return value.get();
      }
      public int increment(){
              return value.incrementAndGet();
      }

      // Alternative implementation as increment but just make the
      // implementation explicit
      public int incrementLongVersion(){
              int oldValue = value.get();
              while (!value.compareAndSet(oldValue, oldValue+1)){
                       oldValue = value.get();
              }
              return oldValue+1;
      }

}
