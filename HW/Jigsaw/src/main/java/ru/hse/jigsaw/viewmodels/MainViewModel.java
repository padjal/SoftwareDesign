package ru.hse.jigsaw.viewmodels;
import de.saxsys.mvvmfx.*;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import ru.hse.jigsaw.models.Tile;
import ru.hse.jigsaw.views.MainView;

public class MainViewModel implements ViewModel{
    @FXML
    GridPane gridPane;

    public MainViewModel(){
        Tile tile = new Tile();
        gridPane.getChildren().add(tile.getTile());
    }
}
