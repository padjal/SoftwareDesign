package hw3;

public class Student {
    public int grade;
    public final String familyName;
    public boolean isPresent;
    public boolean isChecked;
    public final String name;
    public final String surname;

    public Student(String surname, String name, String familyName) {
        this.surname = surname;
        this.name = name;
        this.familyName = familyName;
    }

    /**
     * Parse line to Student.
     * @param input The line to be parsed.
     * @return A parsed student or exception if input is incorrect.
     */
    public static Student parseStudent(String input) throws IllegalArgumentException {
        var data = input.split(" ");
        if(data.length != 3){
            throw new IllegalArgumentException("Error parsing students. Please check text file.");
        }
        return new Student(data[0], data[1], data[2]);
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
