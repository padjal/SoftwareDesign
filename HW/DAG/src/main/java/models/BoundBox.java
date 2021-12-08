package models;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Represents a rectangle containing all points of an origin.
 */
public class BoundBox {
    private Origin origin;

    public BoundBox(Origin origin){
        this.origin = origin;
    }

    public void getBounds(){
        Coord2D left = new Coord2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord2D right = new Coord2D(Double.MIN_VALUE, Double.MIN_VALUE);

        for (var child : origin.getChildren()) {
            var chilcCoords = child.getPosition();
            if(chilcCoords.getX() > right.getX() || chilcCoords.getY() > right.getY() ){
                right = child.getPosition();
            }

            if(chilcCoords.getX() < left.getX() || chilcCoords.getY() < left.getY() ){
                left = child.getPosition();
            }
        }
    }
}
