package ru.hse.jigsaw.viewmodels;
import de.saxsys.mvvmfx.*;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import ru.hse.jigsaw.models.Tile;
import ru.hse.jigsaw.views.MainView;

public class MainViewModel implements ViewModel{
    @FXML
    GridPane gridPane;

    private SimpleIntegerProperty turns = new SimpleIntegerProperty(0);

    public Integer getTurns() {
        return turns.getValue();
    }

    public SimpleIntegerProperty turnsProperty() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns.setValue(turns);
    }

    public MainViewModel(){
    }
}
