package battleship.models;

import battleship.enums.TileState;

import java.util.UUID;

public class Tile {
    public TileState state = TileState.HIDDEN;
    public int row;
    public int column;
    public UUID shipId;

    public Tile(int r, int c){
        row = r;
        column = c;
    }

    @Override
    public String toString() {
        if(state == TileState.HIT){
            return "@";
        }else if(state == TileState.MISSED){
            return "O";
        }else if(state == TileState.SUNK){
            return "X";
        }

        return "?";
    }
}
