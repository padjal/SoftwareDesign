package ru.hse.hw.hw5_addressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class PeopleModel {
    private final ObservableList<Person> people;

    public PeopleModel(){
        this.people = FXCollections.observableArrayList();

        people.add(new Person("john", "adams", "Red road", "London", "YH234", LocalDate.of(1997, 8, 23)));
        people.add(new Person("oliver", "jason", "Mira avenue", "Moscow", "2344dd", LocalDate.of(1867, 3, 1)));
        people.add(new Person("rob", "dilan", "Milky way", "Los angeles", "AMRT33", LocalDate.of(1993, 1, 31)));
        people.add(new Person("jason", "derulo", "Hard road", "Washington", "Wyth", LocalDate.of(1878, 10, 12)));
        people.add(new Person("little", "bob", "Westhame", "Spurs road", "SRGTh43", LocalDate.of(1397, 7, 24)));
    }

    public ObservableList<Person> getPeople() {
        return people;
    }
}
