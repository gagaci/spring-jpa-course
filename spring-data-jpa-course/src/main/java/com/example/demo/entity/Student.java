//package com.example.demo.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "student",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
//        })
//public class Student {
//
//    @Id
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "student_sequence"
//
//    )
//    @Column(
//            name = "id",
//            updatable = false
//    )
//    private Long id;
//    @Column(
//            name = "first_name",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String firstName;
//    @Column(
//            name = "last_name",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String lastName;
//    @Column(
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String email;
//    @Column(name = "age",
//            nullable = false
//    )
//    private Integer age;
//    @OneToOne(
//            mappedBy = "student",
//            orphanRemoval = true
//    )
//    private StudentIdCard studentIdCard;
//
//    @OneToMany(
//            mappedBy = "student",
//            orphanRemoval = true,
//            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
//    )
//    private final List<Book> books = new ArrayList<>();
//
//
//    public Student(String firstName, String lastName, String email, Integer age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.age = age;
//    }
//
//    public Student() {
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    public void addBook(Book book){
//        if (!this.books.contains(book)) {
//            this.books.add(book);
//            book.setStudent(this);
//        }
//    }
//
//    public void removeBook(Book book){
//        if (this.books.contains(book)) {
//          this.books.remove(book);
//          book.setStudent(null);
//        }
//    }
//
//}
