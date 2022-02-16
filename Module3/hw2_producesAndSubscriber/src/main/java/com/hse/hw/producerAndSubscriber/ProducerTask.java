package com.hse.hw.producerAndSubscriber;

import com.hse.hw.producerAndSubscriber.helpers.Colors;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerTask implements Runnable{
    private ArrayBlockingQueue<Integer> numbers;
    private Random random;
    private final int MIN_SLEEP_TIME = 500;
    private final int MAX_SLEEP_TIME = 2500;

    public ProducerTask(ArrayBlockingQueue<Integer> numbers){
        this.numbers = numbers;
        random = new Random();
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        boolean isInterupted = false;

        while (!isInterupted){
            // Generate new number to add
            int newInteger = random.nextInt(100);
            if(numbers.offer(newInteger)){
                System.out.println(Colors.TEXT_GREEN + "Producer: Added " + newInteger + " to the collection." + Colors.TEXT_RESET);
            }else{
                System.out.println(Colors.TEXT_RED + "Producer: Could not add " + newInteger + " to the collection. Collection is full." + Colors.TEXT_RESET);
            }
            try {
                Thread.sleep(random.nextInt(MIN_SLEEP_TIME, MAX_SLEEP_TIME));
            } catch (InterruptedException e) {
                isInterupted = true;
            }
        }
    }
}
