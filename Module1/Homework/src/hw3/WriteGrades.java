package hw3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Future;

/**
 * A program for randomly choosing a student from our group.
 */

public class WriteGrades {

    private final StudentService studentService;

    public static void main(String[] args) {
        WriteGrades writeGrades = new WriteGrades();
        writeGrades.run();
    }

    public WriteGrades(){
        studentService = new StudentService();
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        String input;
        do{
            input = scanner.nextLine();
            switch (input) {
                case "/random" -> studentService.askQuestions();
                case "/list" -> studentService.listAllStudents();
                case "/q" -> studentService.listAllStudentsExit();
            }
        }while (!input.equals("/q"));

    }
}
