package com.hse.hw.producerAndSubscriber;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerTaskTest {

    @Test
    void run_collectionHasElement_SuccessFullyTakesAllElementsOut() {
        // Assign
        var collection = new ArrayBlockingQueue<Integer>(4);
        collection.add(5);
        collection.add(6);

        var consumer = new ConsumerTask(collection);

        var consumerThread = new Thread(consumer);

        // Act
        consumerThread.start();

        // Should not run longer than 2*2500 (max sleep time as configured now. May change.
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Assert
        Assert.assertEquals(0, collection.stream().count());
    }

    @Test
    void run_collectionEmpty_SuccessFullyTakesAllElementsOut() {
        // Assign
        var collection = new ArrayBlockingQueue<Integer>(4);

        var consumer = new ConsumerTask(collection);

        var consumerThread = new Thread(consumer);

        // Act
        consumerThread.start();

        // Should not run longer than 2*2500 (max sleep time as configured now. May change.
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Assert
        Assert.assertEquals(0, collection.stream().count());
    }
}