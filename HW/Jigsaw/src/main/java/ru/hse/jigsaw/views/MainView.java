package ru.hse.jigsaw.views;

import de.saxsys.mvvmfx.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import ru.hse.jigsaw.viewmodels.MainViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements FxmlView<MainViewModel>, Initializable {
    private final int CELL_SIZE = 50;

    @FXML
    GridPane board;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buildBoard();
    }

    private void buildBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                var rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1;");
                board.add(rect, i, j);
            }
        }
    }
}
