package ru.hse.jigsaw.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;
import ru.hse.jigsaw.viewmodels.MainViewModel;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainView implements FxmlView<MainViewModel>, Initializable {
    private final int CELL_SIZE = 50;

    @FXML
    GridPane board;
    @FXML
    GridPane piece;
    @FXML
    Label turnsLabel;

    @InjectViewModel
    private MainViewModel mainViewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buildBoard();
        makeDraggable(piece);
    }

    private double startX;
    private double startY;

    private void makeDraggable(Node node){
        node.setOnMousePressed(mouseEvent -> {
            startX = mouseEvent.getSceneX() - node.getTranslateX();
            startY = mouseEvent.getSceneY() - node.getTranslateY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setTranslateX(mouseEvent.getSceneX() - startX);
            node.setTranslateY(mouseEvent.getSceneY() - startY);
        });
    }

    private void buildBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                var rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1;");
                board.add(rect, i, j);
            }
        }

        clearPieceGenerator();
    }

    private void onGridDragEnter(){
        System.out.println("Draggg");
    }

    private void clearPieceGenerator(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                var rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1;");
                piece.add(rect, i, j);
            }
        }
    }

    @FXML
    private void generatePiece(){
        var rand = new Random();
        clearPieceGenerator();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(rand.nextInt(0, 2) % 2 == 0){
                    var rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                    rect.setStyle("-fx-fill: blue; -fx-stroke: black; -fx-stroke-width: 1;");
                    piece.add(rect, i, j);
                }
            }
        }

        mainViewModel.setTurns(mainViewModel.getTurns() + 1);
    }
}
