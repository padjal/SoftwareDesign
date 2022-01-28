import java.util.Random;

/**
 * Represents a player.
 */
public class Player extends Thread {
    private int balance;
    private final GameTwentyOne gameTwentyOne;
    Random random;
    public String name;

    public Player(String name, GameTwentyOne gameTwentyOne) {
        this.name = name;
        this.gameTwentyOne = gameTwentyOne;
        random = new Random();
        balance = 0;
    }

    /**
     * Gets the current balance a player.
     *
     * @return The sum of all points a player has.
     */
    public int getBalance() {
        return balance;
    }

    private synchronized void playTurn() {
        balance += gameTwentyOne.getCurrentCard();

        System.out.println(toString() + " took a card!");
    }

    /**
     * Runs the task of playing the game of 21 on a player.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            playTurn();

            int sleepTime = random.nextInt(100, 200);

            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Gets the name and balance of a player.
     *
     * @return A string which can identify a player.
     */
    @Override
    public String toString() {
        return name + " with balance: " + balance;
    }
}
