package ru.hse.jigsaw.viewmodels;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MainViewModel implements ViewModel{
    @FXML
    GridPane gridPane;

    private final SimpleIntegerProperty turns = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty elapsedTime = new SimpleIntegerProperty(0);
    private long start;

    public Task stopwatch;

    public Integer getTurns() {
        return turns.getValue();
    }

    public SimpleIntegerProperty turnsProperty() {
        return turns;
    }

    public SimpleIntegerProperty elapsedTimeProperty() {
        return elapsedTime;
    }

    public void startTimer(){
        start = System.currentTimeMillis();

        new Thread(stopwatch).start();
    }

    public void setTurns(Integer turns) {
        this.turns.setValue(turns);
    }

    public MainViewModel(){
        stopwatch = new Task() {
            @Override
            protected Object call() throws Exception {
                while(true){


                    var current = System.currentTimeMillis();

                    updateValue((current - start)/1000);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
