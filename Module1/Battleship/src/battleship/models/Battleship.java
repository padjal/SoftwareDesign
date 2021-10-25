package battleship.models;

public class Battleship extends Ship{
    public Battleship() {
        super(4);
    }

    @Override
    public String toString() {
        return "Battleship with id " + id;
    }
}
