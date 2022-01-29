package com.hse.hw.producerAndSubscriber;

import com.hse.hw.producerAndSubscriber.helpers.Colors;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerTask implements Runnable{
    private ArrayBlockingQueue<Integer> numbers;
    private final Random random;
    private final int MIN_SLEEP_TIME = 500;
    private final int MAX_SLEEP_TIME = 2500;

    public ConsumerTask(ArrayBlockingQueue<Integer> numbers){
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
        while(true){
            var takenElement = numbers.poll();
            if(takenElement != null){
                System.out.println(Colors.TEXT_CYAN + "Consumer: Took out element " + takenElement + "." + Colors.TEXT_RESET);
            }else{
                System.out.println(Colors.TEXT_RED + "Consumer: Could not take out element " + takenElement + ". Collection was empty." + Colors.TEXT_RESET);
            }
            try {
                Thread.sleep(random.nextInt(MIN_SLEEP_TIME, MAX_SLEEP_TIME));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
