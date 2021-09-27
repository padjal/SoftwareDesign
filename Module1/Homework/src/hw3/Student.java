package hw3;

public class Student {
    public int grade;
    public boolean isPresent;
    public boolean isChecked;
    public final String name;
    public final String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Parse line to Student.
     * @param input The line to be parsed.
     * @return A parsed student or exception if input is incorrect.
     */
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

    /**
     * toString but with more information.
     * @return The string object with more information.
     */
    public String toStringWithGrade(){
        var presentString = isPresent?"present":"not present";
        return name + ' ' + surname +" ("+ presentString +") " + grade;
    }
}
