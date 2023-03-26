# ThreadProducerConsumerSenarioInJava

This is a simple Java program that demonstrates the use of the BlockingQueue interface and the LinkedBlockingQueue implementation for inter-thread communication.

The program creates a shared BlockingQueue<Integer> object called blockingQueue, which is used to pass integers between a producer thread and a consumer thread. The producer thread generates 10 integers using IntStream.rangeClosed(1, 10) and adds each integer to the blockingQueue using the put() method. The producer thread then sleeps for 1 second using Thread.sleep(1000).
