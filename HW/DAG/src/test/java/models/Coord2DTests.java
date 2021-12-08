package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class Coord2DTests {
    // Using random in order to be sure it works in every possible scenario.
    private static Random rand;

    @BeforeAll
    static void setup() {
        rand = new Random();
    }

    @Test
    void equals_twoObjectsWithSameCoordinates_true() {
        int x = rand.nextInt();
        int y = rand.nextInt();

        var coordOne = new Coord2D(x, y);
        var coordTwo = new Coord2D(x, y);

        Assertions.assertEquals(coordOne, coordTwo);
    }

    @Test
    void equals_twoObjectsWithDifferentCoordinates_false() {
        final int DEVIATION_FROM_FIRST_COORD = 10;

        int x = rand.nextInt();
        int y = rand.nextInt();

        var coordOne = new Coord2D(x, y);
        var coordTwo = new Coord2D(x + DEVIATION_FROM_FIRST_COORD, y + DEVIATION_FROM_FIRST_COORD);

        Assertions.assertNotEquals(coordOne, coordTwo);
    }

    @Test
    void hashCode_twoObjectsWithSameCoordinates_Same() {
        int x = rand.nextInt();
        int y = rand.nextInt();

        var coordOne = new Coord2D(x, y);
        var coordTwo = new Coord2D(x, y);

        Assertions.assertEquals(coordOne.hashCode(), coordTwo.hashCode());
    }

    @Test
    void hashCode_twoObjectsWithDifferentCoordinates_Different() {
        final int DEVIATION_FROM_FIRST_COORD = 10;

        int x = rand.nextInt();
        int y = rand.nextInt();

        var coordOne = new Coord2D(x, y);
        var coordTwo = new Coord2D(x + DEVIATION_FROM_FIRST_COORD, y + DEVIATION_FROM_FIRST_COORD);

        Assertions.assertNotEquals(coordOne, coordTwo);
    }
}
