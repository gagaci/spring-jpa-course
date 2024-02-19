//package com.example.demo.repository;
//
//import com.example.demo.entity.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface StudentRepository extends JpaRepository<Student, Long> {
//
//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
//    Optional<Student> findStudentByEmail(String email);
//
//    @Query("SELECT s FROM Student s where s.firstName = ?1 and s.age = ?2")
//    List<Student> findStudentByFirstNameAndAgeEquals(
//            String firstName, Integer age);
//
//    @Query(value = "SELECT * FROM student where first_name = ?1 and age = ?2",
//            nativeQuery = true)
//    List<Student> findStudentByFirstNameAndAgeEqualsNative(
//            String firstName, Integer age);
//
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Student u where u.id = ?1")
//    int deleteByIdNative(Long id);
//
//
//}
