package ru.hse.hw.hw5_addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddPersonViewModel {
    private PeopleModel peopleModel;
    @FXML
    Button closeButton;

    public void savePerson(ActionEvent actionEvent) {
        peopleModel.getPeople().add(new Person("Noviq", "pichaga"));

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPeopleModel(PeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }
}
