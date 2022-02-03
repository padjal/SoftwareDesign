package hw3_stream_api.models;

public class Person {
    private final String lastname;
    private final String firstname;
    private final Byte age;

    public Person(String lastname, String firstname, Byte age) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                '}';
    }
}
