package battleship.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Ship {
    public final int size;
    public UUID id;
    public boolean isPlaced = false;
    public int timesHit = 0;
    public List<Tile> forbiddenTiles;

    Ship(int size){
        this.id = UUID.randomUUID();
        this.size = size;
        forbiddenTiles = new ArrayList<Tile>();
    }
}
