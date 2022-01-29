package com.hse.hw.producerAndSubscriber;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTaskTest {

    @Test
    void run_collectionEmpty_successfullyAddElements() {
        // Assign
        var collection = new ArrayBlockingQueue<Integer>(2);

        var producer = new ProducerTask(collection);

        var producerThread = new Thread(producer);

        // Act
        producerThread.start();

        // Should not run longer than 2*2500 (max sleep time as configured now. May change.
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert
        Assert.assertEquals(2, collection.stream().count());
    }

    @Test
    void run_collectionFull_cannotAddMoreElements() {
        // Assign
        var collection = new ArrayBlockingQueue<Integer>(2);
        collection.add(4);
        collection.add(6);

        var initialCollectionCount = collection.stream().count();

        var producer = new ProducerTask(collection);

        var producerThread = new Thread(producer);

        // Act
        producerThread.start();

        // Should not run longer than 2*2500 (max sleep time as configured now. May change.
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert
        Assert.assertEquals(initialCollectionCount, collection.stream().count());
    }
}