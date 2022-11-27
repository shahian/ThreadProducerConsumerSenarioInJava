package com.shahian;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class Main {
    private static final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Runnable producer = () -> IntStream.rangeClosed(1, 10).forEach(number -> {
            try {
                System.out.println("producer produced: Item " + number);
                blockingQueue.put(number);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Runnable consumer = () -> {
            while (true) {
                try {
                    System.out.println("consumer consumed: Item " + blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
