package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository) {
        return args -> {
            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));

            student.addBook(
                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));


            student.addBook(
                    new Book("Think and Grow Rich", LocalDateTime.now()));


            student.addBook(
                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            student.setStudentIdCard(studentIdCard);

            student.addEnrolment(
                    new Enrolment(
                            new EnrolmentId(1L, 1L),
                            student,
                            new Course("EDEX",
                                    "Admission"), LocalDateTime.now().minusDays(3)));

            student.addEnrolment(
                    new Enrolment(
                            new EnrolmentId(2L, 2L),
                            student,
                            new Course("Economics",
                                    "BA"), LocalDateTime.now().minusMonths(43)));

//            student.addEnrolment(
//                    new Course("EDEX",
//                            "Admission"));
//
//            student.enrolToCourse(
//                    new Course("Economics",
//                            "Business"));

            studentRepository.save(student);


            studentRepository.findById(1L)
                    .ifPresent(s -> {
                        System.out.println("fetch book lazy ... ");
                        List<Book> books = s.getBooks();
                        books.forEach(book -> {
                            System.out.println(s.getFirstName() +
                                    " borrowed " +
                                    book.getBookName());
                        });
                    });

//            studentRepository.deleteById(1L);

        };
    }
}
