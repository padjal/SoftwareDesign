package hw3;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * A program for randomly choosing a student from our group.
 */

public class ChooseStudent {
    public static void main(String[] args) {
        var students = getStudents();

        Scanner scanner = new Scanner(System.in);

        String input;
        do{
            input = scanner.nextLine();
            switch (input) {
                case "/random" -> chooseRandomStudent(students, scanner);
                case "/list" -> listAllStudents(students);
                case "/q" -> listAllStudentsExit(students);
            }
        }while (input != "/q");

    }

    private static void listAllStudentsExit(Student[] students) {
        for (var student :
                students) {
            System.out.println(student.toStringWithGrade());
        }

        System.exit(0);
    }

    private static void chooseRandomStudent(Student[] students, Scanner scanner) {
        Random random = new Random();

        var randomNumber = random.nextInt(0, students.length);

        var chosenStudent = students[randomNumber];

        if(!chosenStudent.isPresent){
            var answer = "";

            while (answer != "Y" && answer != "N") {
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
    }

    private static void listAllStudents(Student[] students) {
        for (var student :
                students) {
            System.out.println(student);
        }
    }

    static Student[] getStudents(){
        return new Student[]{
                new Student("Pavel", "Dzhalev"),
                new Student("Ivan", "Marev")
        };
    }
}
