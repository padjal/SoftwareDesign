package ru.hse.hw.hw5_addressbook;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainViewModel implements Initializable {
    @FXML
    TableView peopleTableView;
    @FXML
    Label firstName;
    @FXML
    Label lastName;
    @FXML
    Label street;
    @FXML
    Label city;
    @FXML
    Label postalCode;
    @FXML
    Label birthday;
    private PeopleModel peopleModel;

    public MainViewModel(){
    }

    @FXML
    protected void addPerson(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddressBook.class.getResource("views/add-person-view.fxml"));
        Parent root = fxmlLoader.load();
        ((AddPersonViewModel)fxmlLoader.getController()).setPeopleModel(peopleModel);
        Stage stage = new Stage();
        stage.setTitle("Add person details");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        peopleModel = new PeopleModel();
        peopleTableView.setItems(peopleModel.getPeople());

        peopleTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> showPersonDetails(observableValue));
    }

    private void showPersonDetails(ObservableValue observableValue) {
        if(observableValue.getValue().getClass() != Person.class){
            return;
        }

        var selectedPerson = (Person)observableValue.getValue();
        firstName.setText(selectedPerson.firstName);
        lastName.setText(selectedPerson.lastName);
        city.setText(selectedPerson.city);
        street.setText(selectedPerson.street);
        postalCode.setText(selectedPerson.postalCode);
        birthday.setText(selectedPerson.birthday.toString());
    }
}
