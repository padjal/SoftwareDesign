package ru.hse.hw.hw5_addressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PeopleModel {
    private final ObservableList<Person> people;

    public PeopleModel(){
        this.people = FXCollections.observableArrayList();

        people.add(new Person("john", "adams"));
        people.add(new Person("ivan", "kulekov"));
    }

    public ObservableList<Person> getPeople() {
        return people;
    }
}
