package ru.hse.hw.hw5_addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    private boolean validateFields(){
        if(firstName.getText().isBlank() || lastName.getText().isBlank() || street.getText().isBlank() || city.getText().isBlank() || postalCode.getText().isBlank() || birthday.getValue() == null){
            return false;
        }
        return true;
    }

    public void savePerson(ActionEvent actionEvent) {
        if(!validateFields()){
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid input");
            alert.setContentText("Some fields are not filled. Please check all fields before saving");
            alert.showAndWait();
            return;
        }

        peopleModel.getPeople().add(new Person(firstName.getText(), lastName.getText(), street.getText(), city.getText(), postalCode.getText(), birthday.getValue()));

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPeopleModel(PeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }
}
