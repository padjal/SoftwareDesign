package ru.hse.jigsaw.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
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
    Group piece2;
    @FXML
    Label turnsLabel;
    @FXML
    Label time;

    @InjectViewModel
    private MainViewModel mainViewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buildBoard();
        makeDraggable(piece2);
        mainViewModel.startTimer();

        turnsLabel.textProperty().bind(mainViewModel.turnsProperty().asString());

        board.setOnMouseClicked(clicked -> System.out.println("board clicked!"));

        //time.textProperty().bind(mainViewModel.elapsedTimeProperty().asString());

        piece2.setOnDragDetected(dragged ->
        {
            Dragboard db = piece2.startDragAndDrop(TransferMode.NONE);

            ClipboardContent content = new ClipboardContent();
            content.putString("qj mi");
            db.setContent(content);
        });

        time.textProperty().bind(mainViewModel.stopwatch.valueProperty().asString());

        board.setOnDragDropped(dropped -> {
                System.out.println("Draggg");
            }
        );


//        piece2.setOnDragDetected(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Grafgggggg");
//
//                mouseEvent.consume();
//            }
//        });

        turnsLabel.setOnDragDetected(dragDetected -> System.out.println("heyy"));

        board.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                System.out.println("kura mi qnko!");
            }
        });
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

    private void clearPieceGenerator(){
        // TODO: Implement clear of new piece
    }

    @FXML
    private void generatePiece(){
        var rand = new Random();
        clearPieceGenerator();

        // Decide which piece to use. There are 9 possible figures
        int pieceVariation = rand.nextInt(5); // possible results are [0, 8] - 9 options

        piece2.getChildren().clear();

        var rect1 = new Rectangle(CELL_SIZE, CELL_SIZE);
        rect1.setStyle("-fx-fill: blue; -fx-stroke: black; -fx-stroke-width: 1;");

        var rect2 = new Rectangle(CELL_SIZE, CELL_SIZE);
        rect2.setStyle("-fx-fill: blue; -fx-stroke: black; -fx-stroke-width: 1;");

        var rect3 = new Rectangle(CELL_SIZE, CELL_SIZE);
        rect3.setStyle("-fx-fill: blue; -fx-stroke: black; -fx-stroke-width: 1;");

        var rect4 = new Rectangle(CELL_SIZE, CELL_SIZE);
        rect4.setStyle("-fx-fill: blue; -fx-stroke: black; -fx-stroke-width: 1;");

        var rect5 = new Rectangle(CELL_SIZE, CELL_SIZE);
        rect4.setStyle("-fx-fill: blue; -fx-stroke: black; -fx-stroke-width: 1;");

        // Generating different shapes here
        switch (4){
            case 0:
                rect2.setX(CELL_SIZE);
                rect3.setY(CELL_SIZE);
                rect4.setY(CELL_SIZE*2);
                piece2.getChildren().addAll(rect1, rect2, rect3, rect4);
                break;
            case 1:
                rect2.setY(CELL_SIZE);
                rect3.setY(CELL_SIZE);
                rect3.setX(CELL_SIZE);
                rect4.setX(CELL_SIZE);
                rect4.setY(CELL_SIZE*2);
                piece2.getChildren().addAll(rect1, rect2, rect3, rect4);
                break;
            case 3:
                rect2.setX(CELL_SIZE);
                rect3.setX(CELL_SIZE*2);
                rect4.setY(CELL_SIZE);
                rect5.setY(CELL_SIZE*2);
                piece2.getChildren().addAll(rect1, rect2, rect3, rect4, rect5);
                break;
            case 4:
                rect1.setX(CELL_SIZE);
                rect2.setX(CELL_SIZE);
                rect2.setY(CELL_SIZE);
                rect3.setX(CELL_SIZE);
                rect3.setY(CELL_SIZE*2);
                rect4.setY(CELL_SIZE*2);
                rect5.setY(CELL_SIZE*2);
                rect5.setX(CELL_SIZE*2);
                piece2.getChildren().addAll(rect1, rect2, rect3, rect4, rect5);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:

                break;
        }

        // Add all pieces to the group


        var rotationRand = rand.nextInt(0, 3);
        piece2.setRotate(90*rotationRand);

        var flipRand = rand.nextInt(0, 2);
        var flip = new Rotate(180*flipRand, CELL_SIZE*1.5, CELL_SIZE*1.5, 0.0, new Point3D(0.0, 1.0, 0.0));

        piece2.getTransforms().add(flip);

        mainViewModel.setTurns(mainViewModel.getTurns() + 1);
    }
}
