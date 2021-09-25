package hw3;

public class Student {
    public String name;
    public String surname;
    public int grade;
    public boolean isPresent;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name +' '+ surname;
    }

    public String toStringWithGrade(){
        return name +' '+ surname +' '+ grade;
    }
}
