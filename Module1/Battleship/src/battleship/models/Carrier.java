package battleship.models;

public class Carrier extends Ship{
    public Carrier() {
        super(5);
    }

    @Override
    public String toString() {
        return "Carrier with id " + id;
    }
}
