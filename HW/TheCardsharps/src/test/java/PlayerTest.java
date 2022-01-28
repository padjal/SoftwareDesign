import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getBalance_PlayersHasNotYetPlayedInAGame_BalanceIsZero() {
        //Assign
        GameTwentyOne game = new GameTwentyOne();
        Player player = new Player("testPlayer", game);
        //Act

        //Assert
        Assertions.assertEquals(player.getBalance(), 0);
    }

    @Test
    void run_PlayerInGame_BalanceShouldIncrement() throws InterruptedException {
        //Assign
        GameTwentyOne game = new GameTwentyOne();
        Player player = new Player("testPlayer", game);

        //Act
        game.start(List.of(player));
        Thread.sleep(1000);
        game.stop(List.of(player));

        //Assert
        Assertions.assertTrue(player.getBalance() > 0);
    }

    @Test
    void testToString_Player_ReturnPlayerDetailsInAString() throws InterruptedException{
        //Assign
        GameTwentyOne game = new GameTwentyOne();
        Player player = new Player("testPlayer", game);

        //Act
        game.start(List.of(player));
        Thread.sleep(1000);
        game.stop(List.of(player));

        var playerBalance = player.getBalance();
        //Assert
        Assertions.assertEquals("testPlayer with balance: " + playerBalance, player.toString());
    }
}