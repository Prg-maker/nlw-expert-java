package com.rockeseat.certificate_nlw.modules.students.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="answers_cetifications_students")
public class AnswersCerticationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name ="cetification_id")
    private UUID certificationID;

    @ManyToOne
    @JoinColumn(name  = "certification_id", insertable = false , updatable = false)
    private CertificationsStudentEntity certificationsStudentEntity;


    @Column(name ="student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false , updatable = false)
    private StudentEntity studentEntity;  

    

    @Column(name ="question_id")
    private UUID questionId;

    @Column(name ="answer_id")
    private UUID answerID;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;

 
}
