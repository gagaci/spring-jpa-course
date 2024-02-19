package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
@Getter
@Setter
public class Enrolment {

    @EmbeddedId
    private EnrolmentId enrolmentId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id",
    foreignKey = @ForeignKey(name = "enrolment_student_id_fk"))
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id",
    foreignKey = @ForeignKey(name = "enrolment_course_id_fk"))
    private Course course;

    @Column(
            name = "created_at",
    nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public Enrolment(Student student, Course course,  LocalDateTime createdAt) {
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public Enrolment(EnrolmentId enrolmentId, Student student, Course course,
                     LocalDateTime createdAt) {
        this.enrolmentId = enrolmentId;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public Enrolment() {
    }


}
