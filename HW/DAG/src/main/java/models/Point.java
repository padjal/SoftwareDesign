package models;

/**
 * Represents a physical point.
 */
public class Point {
    private Coord2D position;

    public boolean isChecked;

    public Point(double x, double y){
        position = new Coord2D(x, y);
    }

    /**
     * Gets the current coordinates of a physical point.
     * @return The mathematical coordinates of the physical points.
     */
    public Coord2D getPosition(){
        return position;
    }

    /**
     * Sets the mathematical coordinates of a physical point.
     * @param newValue The new mathematical point.
     */
    public void setPosition(Coord2D newValue){
        position = newValue;
    }
}
