package com.rockeseat.certificate_nlw.modules.students.entities;

import java.util.UUID;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="certifications")
public class CertificationsStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grate;

    @JoinColumn(name="student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name="student_id" , insertable = false, updatable = false)
    private StudentEntity studentEntity;

    
    @OneToMany
    @JoinColumn(name ="answer_certification_id", insertable = false , updatable = false)
    List<AnswersCerticationsEntity> answersCerticationsEntity;


}