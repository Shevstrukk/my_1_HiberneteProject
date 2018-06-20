package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    private int level;
    @OneToMany(mappedBy="student", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Book> books;

    public Student(){}

    public Student(String firstName, String lastName, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        books=new ArrayList<Book>();
    }
    public void addBook(Book book){
        book.setStudent(this);
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLevel() {
        return level;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString(){
        return "Student "+id+" "+firstName+" "+lastName+" "+level;
    }
}
