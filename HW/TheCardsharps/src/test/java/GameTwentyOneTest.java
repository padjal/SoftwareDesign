import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTwentyOneTest {
final Random random = new Random();

    @Test
    void generatePlayers_NumberOfPlayers_AListOfTheSpecifiedNumberOfPlayers() {
        //Assign
        var game = new GameTwentyOne();
        int numberOfPlayers = random.nextInt(0, 100);

        //Act
        var players = game.generatePlayers(numberOfPlayers);

        //Assert
        Assertions.assertEquals(players.stream().count(), numberOfPlayers);
    }

    @Test
    void generatePlayers_LessThanOne_ThrowsIllegalArgumentException() {
        //Assign
        var game = new GameTwentyOne();
        var numberLessThanOne = random.nextInt(-100, 1);

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> game.generatePlayers(numberLessThanOne));
    }

    @Test
    void start_PlayersProvided_PlayersStartGettingPoints() throws InterruptedException {
        //Assign
        var game = new GameTwentyOne();
        var numberOfPlayers = random.nextInt(1, 10);
        var players = game.generatePlayers(numberOfPlayers);

        //Act
        game.start(players);
        Thread.sleep(1000);
        game.stop(players);

        //Assert
        for (var player :
                players) {
            Assertions.assertTrue(0 < player.getBalance());
        }
    }

    @Test
    void start_NoPlayers_IllegalExceptionThrown() throws InterruptedException {
        //Assign
        var game = new GameTwentyOne();
        var players = new ArrayList<Player>();

        //Act

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> game.start(players));
    }

    @Test
    void stop_PlayersProvided_PlayersBalanceDoesntChangeAnymore() throws InterruptedException {
        //Assign
        var game = new GameTwentyOne();
        var player = new Player("TestPlayer", game);

        //Act
        game.start(List.of(player));
        Thread.sleep(1000);
        game.stop(List.of(player));

        int playerBalanceAfterStop = player.getBalance();
        Thread.sleep(500);

        int playerBalanceAfterTimeAfterStop = player.getBalance();

        //Assert
        Assertions.assertEquals(playerBalanceAfterStop, playerBalanceAfterTimeAfterStop);
    }

    @Test
    void getCurrentCard_ReturnsANumberBetweenOneAndTen() {
        //Assign
        var game = new GameTwentyOne();

        //Act
        int card = game.getCurrentCard();

        //Assert
        Assertions.assertTrue(card >= 1 && card <= 10);
    }
}