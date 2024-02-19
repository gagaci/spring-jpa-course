//package com.example.demo.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@Entity(name = "Book")
//@Getter
//@NoArgsConstructor
//@Table(name = "book")
//public class Book {
//    @Id
//    @SequenceGenerator(
//            name = "book_sequence",
//            sequenceName = "book_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "book_sequence"
//
//    )
//    @Column(
//            name = "id",
//            updatable = false
//    )
//    private Long id;
//
//
//    @ManyToOne
//    @JoinColumn(
//            name = "student_id",
//            nullable = false,
//            referencedColumnName = "id",
//            foreignKey = @ForeignKey(
//                    name = "student_book_fk")
//    )
//    private Student student;
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    public void setPublishedAt(LocalDateTime publishedAt) {
//        this.publishedAt = publishedAt;
//    }
//
//    @Column(
//            name = "book_name",
//            nullable = false
//    )
//    private String bookName;
//
//    @Column(
//            name = "published_at",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIMEZONE NOT NULL"
//    )
//    private LocalDateTime publishedAt;
//
//    public Book(String bookName, LocalDateTime publishedAt) {
//        this.bookName = bookName;
//        this.publishedAt = publishedAt;
//    }
//}
