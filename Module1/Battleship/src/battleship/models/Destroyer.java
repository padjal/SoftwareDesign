package battleship.models;

public class Destroyer extends Ship{
    public Destroyer(){
        super(2);
    }

    @Override
    public String toString() {
        return "Destroyer with id " + id;
    }
}
