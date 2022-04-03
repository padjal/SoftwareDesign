package ru.hse.jigsaw;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.hse.jigsaw.viewmodels.MainViewModel;
import ru.hse.jigsaw.views.MainView;

import java.io.IOException;

import static javafx.application.Application.launch;

public class GameStarter extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(GameStarter.class.getResource("views/MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Jigsaw game");
        stage.setScene(scene);
        stage.show();*/

        stage.setTitle("Jigsaw puzzle");

        ViewTuple<MainView, MainViewModel> viewTuple = FluentViewLoader.fxmlView(MainView.class).load();

        Parent root = viewTuple.getView();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}