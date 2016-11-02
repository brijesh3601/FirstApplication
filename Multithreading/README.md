

Introduction 
<hr/>
- Package "com.java7.threads.demo" demonstrates Java7 Multhreading features such as Executor, Callable Future & Atomic class <br/>
- Package "com.java8.threads.demo" demonstrates Java8 Multhreading features such as CompletableFuture, RecursiveAction & lambda implementation of Threads    


Futures
<hr/>
Futures were introduced in Java 5. They are objects that promise to hold the result of something that (maybe) hasn't occurred yet. They are created, for example, when a task (i.e Runnable or Callable) is submitted to an executor. The caller can use the the future to check whether the task isDone(), or wait for it to finish using get().

CompletableFutures
<hr/>
CompletableFutures were introduced in Java 8, and are in fact an evolution of regular Futures inspired by Google's Listenable Futures. They are Futures that also allow you to string tasks together in a chain. You can use them to tell some worker thread to "go do some task X, and when you're done, go do this other thing using the result of X".



java.util.concurrent.atomic 
<hr/>
A small toolkit of classes that support lock-free thread-safe programming on single variables. In essence, the classes in this package extend the notion of volatile values, fields, and array elements to those that also provide an atomic conditional update operation of the form: 
 boolean compareAndSet(expectedValue, updateValue);
 
This method (which varies in argument types across different classes) atomically sets a variable to the updateValue if it currently holds the expectedValue, reporting true on success. The classes in this package also contain methods to get and unconditionally set values, as well as a weaker conditional atomic update operation weakCompareAndSet described below. 

The specifications of these methods enable implementations to employ efficient machine-level atomic instructions that are available on contemporary processors. However on some platforms, support may entail some form of internal locking. Thus the methods are not strictly guaranteed to be non-blocking -- a thread may block transiently before performing the operation. 



RecursiveAction
<hr/>
java.util.concurrent.RecursiveAction has been introduced in JDK 7 and is the part of fork join framework in Java. RecursiveAction extends java.util.concurrent.ForkJoinTask. The important method of RecursiveAction is compute(). RecursiveAction works recursively. It works differently in comparison to old recursive call in our program. Multiple threads work to compute a task parallelly in recursive action. On the basis of some condition we divide the task and submitted to perform computation. RecursiveAction works with fork and join which is provided by java.util.concurrent.ForkJoinTask . RecursiveAction is invoked by ForkJoinPool.

Divide and Conquer Concept in RecursiveAction
RecursiveAction is recursive action by its name. For a given task, we make a plan to divide it in small task and then all those small tasks are started simultaneously by different threads provided by ForkJoinPool. Finally we get the result and conquer. We will understand it clearly in the example.

In the example we have class Square in RecursiveActionTest.java. Square is extending RecursiveAction. RecursiveAction has the compute() method that is automatically called when RecursiveAction object is invoked by ForkJoinPool. compute() method is also called when ForkJoinTask.fork() is invoked. We have been provided with an array of integers. We have divided the array on the basis of a limit value. We find the midpoint and in context to mid point we have left and right elements of array. Both left and right task parallelly started by fork() method. Now calling by join() we ensure that computation has been finished. If task has not been finished join waits for the task completion. 




References
<hr/>

* http://www.concretepage.com/java/jdk7/example-of-recursiveaction-in-java <br/>
* http://www.vogella.com/tutorials/JavaConcurrency/article.html
* http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
