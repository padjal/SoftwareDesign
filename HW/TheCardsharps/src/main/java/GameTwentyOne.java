import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Represents the game of 21 in our example. Mainly responsible for the
 * deck of cards and displaying the winner.
 */
public class GameTwentyOne {
    private int currentCard;
    private final Random random;

    public GameTwentyOne() {
        random = new Random();
        currentCard = random.nextInt(0, 11);
    }

    /**
     * Gets the player with the most points (winner of the game) and displays
     * their information.
     *
     * @param players All players participating in the current game.
     */
    private void displayWinner(List<Player> players) {
        int max = Integer.MIN_VALUE;
        Player winner = null;

        for (var player : players) {
            if (player.getBalance() > max) {
                max = player.getBalance();
                winner = player;
            }
        }

        System.out.println("The winner of this game is " + winner);
    }

    /**
     * Generates players for the current game.
     * @param honestPlayers The number of players that are going to play in the
     *                        current game.
     * @return A list of players playing in the current game.
     * @throws IllegalArgumentException When the number of players is less than 1.
     */
    public List<Player> generatePlayers(int honestPlayers) throws IllegalArgumentException {
        if (honestPlayers < 1) {
            throw new IllegalArgumentException("The number of players should be at least 1.");
        }

        var players = new ArrayList<Player>();

        for (int i = 0; i<honestPlayers; ++i){
            var playerName = "HonestPlayer" + i;
            players.add(new Player(playerName, this));
        }

        return players;
    }

    /**
     * Starts the game of 21.
     * @param players The players participating in the game which will begin to play.
     * @exception IllegalArgumentException Thrown when there is less than one player provided.
     */
    public void start(List<Player> players) {
        if(players == null){
            throw new NullPointerException();
        }

        if (players.stream().count() == 0){
            throw new IllegalArgumentException("There should be at least one player in order to play" +
                    "the game!");
        }

        System.out.println("Game started!");

        for (var player :
                players) {
            player.start();
        }
    }

    /**
     * Stops the game of 21.
     * @param players The players participating in the game which will stop playing.
     */
    public void stop(List<Player> players) {
        System.out.println("The game has ended!");
        for (var player :
                players) {
            player.interrupt();
        }

        displayWinner(players);
    }

    /**
     * Gets the top card of the deck of cards and generates a new one, so the
     * next player also has one.
     * @return An integer representing the top deck card.
     */
    public int getCurrentCard() {
        int oldCard = currentCard;
        currentCard = random.nextInt(0, 11);
        return oldCard;
    }
}
