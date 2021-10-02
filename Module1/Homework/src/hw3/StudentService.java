package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class StudentService {
    private ArrayList<Student> students;
    private final String PATH = "students.txt";
    private final Random random = new Random();

    public StudentService() {
        try {
            students = getStudents();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (students.size() == 0) {
            System.exit(0);
        }
    }

    /**
     * Gets all students from file.
     *
     * @return All successfully parsed students from the file.
     */
    public ArrayList<Student> getStudents() throws FileNotFoundException, ParseException {
        var file = new File(PATH);
        var students = new ArrayList<Student>();

        if (!file.exists()) {
            throw new FileNotFoundException("Could not find specified file.");
        }

        var fileReader = new Scanner(file);

        try {
            while (fileReader.hasNextLine()) {
                var studentString = fileReader.nextLine();
                students.add(Student.parseStudent(studentString));
            }
        } catch (Exception exception) {
            throw new ParseException("Could not parse students.", 0);
        }

        return students;
    }

    /**
     * Display all students in the given arraylist to console.
     */
    public void listAllStudents() {
        for (var student :
                students) {
            System.out.println(student);
        }
    }

    /**
     * Display all students to console and close app.
     */
    public void listAllStudentsExit() {
        for (var student :
                students) {
            System.out.println(student.toStringWithGrade());
        }

        System.exit(0);
    }

    /**
     * Gets a random student (if available and asks question about them.)
     */
    private Student chooseRandomStudent() {

        // Check if there are available students.
        var availableStudents = students.stream().filter(s -> !s.isChecked).toList();
        if (availableStudents.size() == 0) {
            System.out.println("All students have been checked.");
            return null;
        }

        var randomNumber = random.nextInt(0, availableStudents.size());
        var chosenStudent = availableStudents.get(randomNumber);

        chosenStudent.isChecked = true;

        return chosenStudent;
    }

    /**
     * Ask questions and get info about a random student.
     */
    public void askQuestions() {
        var student = chooseRandomStudent();
        if (student == null) {
            return;
        }
        var scanner = new Scanner(System.in);
        var answer = "";

        // Ask questions
        while (!(Objects.equals(answer, "Y") || Objects.equals(answer, "N"))) {
            System.out.println(student + " was randomly selected.");
            System.out.print("Is student present? (Y/N):");
            answer = scanner.nextLine();

            if (Objects.equals(answer, "Y")) {
                student.isPresent = true;
                int grade = 0;
                while (grade < 1 || grade > 10) {
                    System.out.print("Enter grade for " + student.name + ' ' + student.surname +
                            " (1 - 10) : ");
                    grade = scanner.nextInt();
                }
                student.grade = grade;
                return;
            }
            if (Objects.equals(answer, "N")) {
                askQuestions();
                return;
            }
        }
    }
}
