package models;

import java.util.Objects;

/**
 * Represents a mathematical point.
 */
public class Coord2D {
    private final double x;
    private final double y;

    public Coord2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Checks whether two points are the same.
     * @param o The second point.
     * @return True if points are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord2D coord2D = (Coord2D) o;
        return Double.compare(coord2D.x, x) == 0 && Double.compare(coord2D.y, y) == 0;
    }

    /**
     * Calculates a unique number based on the point's state.
     * @return A number which represents the state of the point.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
