package hw3;

public class Student {
    public String name;
    public String surname;
    public int grade;
    public boolean isPresent;
    public boolean isChecked;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Student parseStudent(String input){
        var data = input.split(" ");
        if(data.length > 2){
            throw new IllegalArgumentException("Error parsing students. Please check text file.");
        }
        return new Student(data[0], data[1]);
    }

    @Override
    public String toString() {
        return name +' '+ surname;
    }

    public String toStringWithGrade(){
        var presentString = isPresent?"present":"not present";
        return name + ' ' + surname +" ("+ presentString +") " + grade;
    }
}
