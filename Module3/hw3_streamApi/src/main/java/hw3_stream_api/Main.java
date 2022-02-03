package hw3_stream_api;

import hw3_stream_api.models.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Антонов", "Борис", (byte) 15),
                new Person("Антонов", "Виктор", (byte) 15),
                new Person("Антонов", "Борис", (byte) 12),
                new Person("Борисов", "Антон", (byte) 9)
        );

        System.out.println("Unsorted array");
        printPeople(people);

        var sorted = sortedPeople(people);

        System.out.println("Sorted array");
        printPeople(sorted);
    }

    private static List<Person> sortedPeople(List<Person> people){
        return people
                .stream()
                .sorted(Comparator
                        .comparing(Person::getLastname)
                        .thenComparing(Person::getFirstname)
                        .thenComparing(Person::getAge, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    private static void printPeople(List<Person> people){
        people.stream().forEach(p -> System.out.println(p));
    }
}
