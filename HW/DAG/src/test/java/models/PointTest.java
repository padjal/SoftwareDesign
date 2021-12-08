package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

class PointTest {
    private static Random rand;

    @BeforeAll
    static void setup(){
        rand = new Random();
    }

    @Test
    void getPosition_createWithConstructor_coordinatesMatchInitialValues() {
        double x = rand.nextDouble();
        double y = rand.nextDouble();

        var point = new Point(x, y);

        var coord = new Coord2D(x, y);

        Assertions.assertEquals(point.getPosition(), coord);
    }

    @Test
    void setPosition_coordinatesChanged_returnsRightCoordinates() {
        double x = rand.nextDouble();
        double y = rand.nextDouble();

        var point = new Point(x, y);

        x = rand.nextDouble();
        y = rand.nextDouble();

        var newCoords = new Coord2D(x, y);

        point.setPosition(newCoords);

        Assertions.assertEquals(point.getPosition(), newCoords);
    }
}