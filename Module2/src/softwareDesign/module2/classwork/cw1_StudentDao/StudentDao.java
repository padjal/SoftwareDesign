package softwareDesign.module2.classwork.cw1_StudentDao;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class StudentDao {
    class Student{
        String name;
        String surname;
        String group;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(group, student.group);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, group);
        }
    }

    private final String filePath;
    HashSet<Student> students;

    public StudentDao(String filePath) {
        this.filePath = filePath;
        readStudents();
    }

    public List<Student> findStudent(String name, String surname) {
        return students.stream().filter(s -> Objects.equals(s.name, name) && Objects.equals(s.surname, surname)).toList();
    }

    public List<Student> findStudent(String surname){
        return students.stream().filter(s->Objects.equals(s.surname, surname)).toList();
    }

    void readStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String currentLine = br.readLine();
            while (currentLine != null){
                var args = currentLine.split(";");
                if(args.length != 3){
                    return;
                }
                var student = new Student();
                student.name = args[0];
                student.surname = args[1];
                student.group = args[2];

                students.add(student);
                currentLine = br.readLine();
            }
        } catch (IOException ioException) {
            throw new UncheckedIOException("There has been an error while reading from file.", ioException);
        }
    }
}