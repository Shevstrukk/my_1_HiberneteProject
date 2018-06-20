import models.Book;
import models.Student;
import services.StudentService;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {


        StudentService studentService = new StudentService();
        Student student = new Student("dima", "Koval", 2);
        studentService.saveStudent(student);
        Book voina=new Book("Tolstoi","Voina i mir");
        voina.setStudent(student);
        student.addBook(voina);
        Book capital=new Book("Karl_Marks", "Capital");
        capital.setStudent(student);
        student.addBook(capital);
        studentService.updateStudent(student);
        //studentService.deleteStudent(student);
        System.out.println(studentService.findStudent(1));
    }
}