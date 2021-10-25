package battleship.models;

public class Cruiser extends Ship{
    public Cruiser() {
        super(3);
    }

    @Override
    public String toString() {
        return "Cruiser with id " + id;
    }
}
