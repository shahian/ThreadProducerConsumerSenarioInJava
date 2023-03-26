# ThreadProducerConsumerSenarioInJava
### content:
1. [Definition](#Definition)
2. [Reason For Use](#reason)
3. [CodeExplanation](#CodeExplanation)

## Definition
In concurrent programming, a producer-consumer pattern is a common paradigm for solving inter-thread communication problems. It involves two types of threads: producers and consumers.

Producers are threads that generate data or work and add it to a shared data structure or queue. In the context of the code you provided, the producer thread generates integers using IntStream.rangeClosed(1, 10) and adds each integer to the blockingQueue using the put() method.

Consumers, on the other hand, are threads that remove data or work from the shared data structure or queue, and perform some operation on it. In the context of the code you provided, the consumer thread waits for integers to become available in the blockingQueue using the take() method, and consumes them by printing a message indicating which integer it consumed.

The producer and consumer threads work concurrently, with the producer thread adding items to the queue while the consumer thread waits for items to become available in the queue. Once an item becomes available, the consumer thread consumes it, allowing the producer thread to add more items to the queue.

This pattern is useful in scenarios where there is a clear separation between the generation and consumption of data or work, and where the rate of generation and consumption may be different. By using a shared data structure or queue, producers and consumers can work asynchronously and avoid contention for shared resources, leading to more efficient and scalable code.

## reason
We use producer and consumer threads to solve the problem of inter-thread communication, which can arise when two or more threads in a program need to share data or coordinate their activities. In a multi-threaded program, different threads may execute concurrently, meaning that they may overlap and interfere with each other's work. If two or more threads need to access the same data structure or resource at the same time, this can lead to race conditions, synchronization issues, and other types of errors that can cause the program to behave incorrectly or crash.

The producer-consumer pattern provides a way to avoid these issues by using a shared data structure or queue to transfer data between threads. The producer thread generates data or work and adds it to the queue, while the consumer thread removes data or work from the queue and processes it. By using a queue, we ensure that the producer and consumer threads do not interfere with each other's work, and that each thread operates at its own pace. This allows us to write concurrent code that is correct, efficient, and scalable, even in scenarios where different threads need to access the same data or resource.

## CodeExplanation
This is a simple Java program that demonstrates the use of the BlockingQueue interface and the LinkedBlockingQueue implementation for inter-thread communication.

The program creates a shared BlockingQueue<Integer> object called blockingQueue, which is used to pass integers between a producer thread and a consumer thread. The producer thread generates 10 integers using IntStream.rangeClosed(1, 10) and adds each integer to the blockingQueue using the put() method. The producer thread then sleeps for 1 second using Thread.sleep(1000).
  
The consumer thread continuously loops, waiting for an integer to become available in the blockingQueue. When an integer is available, it consumes the integer using the take() method and prints a message indicating which integer it consumed.
  
The program uses lambda expressions to define the producer and consumer Runnable objects, which are then passed to Thread objects and started in separate threads. The producer thread generates integers and adds them to the blockingQueue, while the consumer thread waits for integers to become available in the blockingQueue and consumes them.
  
The use of a BlockingQueue allows for safe inter-thread communication between the producer and consumer threads, ensuring that items are added and consumed in a thread-safe manner. The LinkedBlockingQueue implementation is used because it provides an unbounded blocking queue, which means that the producer thread can continue to add items to the queue without waiting for the consumer thread to consume them.
