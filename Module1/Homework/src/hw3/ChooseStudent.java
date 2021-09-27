package hw3;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * A program for randomly choosing a student from our group.
 */

public class ChooseStudent {
    public static void main(String[] args) {
        var students = getStudents();

        if(students == null){
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);

        String input;
        do{
            input = scanner.nextLine();
            switch (input) {
                case "/random" -> chooseRandomStudent(students, scanner);
                case "/list" -> listAllStudents(students);
                case "/q" -> listAllStudentsExit(students);
            }
        }while (!input.equals("/q"));

    }

    private static void listAllStudentsExit(ArrayList<Student> students) {
        for (var student :
                students) {
            System.out.println(student.toStringWithGrade());
        }

        System.exit(0);
    }

    /**
     * Gets a random student (if available and asks question about them.)
     * @param students All students initialized by the program.
     * @param scanner A scanner object for reading user input.
     */
    private static void chooseRandomStudent(ArrayList<Student> students, Scanner scanner) {
        Random random = new Random();

        // Check if there are available students.
        var availableStudents = students.stream().filter(s -> !s.isChecked).toList();
        if(availableStudents.size() == 0){
            System.out.println("All students have been checked.");
            return;
        }

        var randomNumber = random.nextInt(0, availableStudents.size());
        var chosenStudent = availableStudents.get(randomNumber);

        chosenStudent.isChecked = true;

        var answer = "";

        //Ask questions
        while (!(Objects.equals(answer, "Y") || Objects.equals(answer, "N"))) {
            System.out.println(chosenStudent + " was randomly selected.");
            System.out.print("Is student present? (Y/N):");
            answer = scanner.nextLine();

            if(Objects.equals(answer, "Y")){
                chosenStudent.isPresent = true;
                int grade = 0;
                while (grade <1 || grade > 10){
                    System.out.print("Enter grade for " + chosenStudent.name + ' ' + chosenStudent.surname +
                            " (1 - 10) : ");
                    grade = scanner.nextInt();
                }
                chosenStudent.grade = grade;
                return;
            }
            if(Objects.equals(answer, "N")){
                chooseRandomStudent(students, scanner);
                return;
            }
        }

    }

    private static void listAllStudents(ArrayList<Student> students) {
        for (var student :
                students) {
            System.out.println(student);
        }
    }

    static ArrayList<Student> getStudents(){
        var students = new ArrayList<Student>();
        try {
            var file = new File("resources/students.txt");
            var fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){
                var studentString = fileReader.nextLine();
                try {
                    students.add(Student.parseStudent(studentString));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    return null;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

        return students;
    }
}
