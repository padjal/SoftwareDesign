package ru.hse.hw.hw5_addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPersonViewModel {
    private PeopleModel peopleModel;
    @FXML
    Button closeButton;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField street;
    @FXML
    TextField city;
    @FXML
    TextField postalCode;
    @FXML
    DatePicker birthday;

    public void savePerson(ActionEvent actionEvent) {
        peopleModel.getPeople().add(new Person(firstName.getText(), lastName.getText(), street.getText(), city.getText(), postalCode.getText(), birthday.getValue()));

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPeopleModel(PeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }
}
