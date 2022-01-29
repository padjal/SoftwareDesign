package com.hse.hw.producerAndSubscriber;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    final static int BUFFER_SIZE = 4;

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(BUFFER_SIZE);

        ProducerTask producer = new ProducerTask(queue);
        ConsumerTask consumer = new ConsumerTask(queue);

        var producerThread = new Thread(producer);
        var consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
