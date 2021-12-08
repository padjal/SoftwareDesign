package models;

public class Space {
    private final Origin origin;

    public Space(){
        this.origin = new Origin(0.0, 0.0, this);
    }

    /**
     * Gets the mathematical coordinates of the origin point.
     * @return The coordinates of the origin.
     */
    public Origin getOrigin(){
        return origin;
    }
}
