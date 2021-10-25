package battleship.models;

public class Submarine extends Ship{
    public Submarine() {
        super(1);
    }

    @Override
    public String toString() {
        return "Submarine with id " + id;
    }
}
