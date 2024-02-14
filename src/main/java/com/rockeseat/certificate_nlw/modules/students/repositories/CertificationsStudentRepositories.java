package com.rockeseat.certificate_nlw.modules.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rockeseat.certificate_nlw.modules.students.entities.CertificationsStudentEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface  CertificationsStudentRepositories extends JpaRepository<CertificationsStudentEntity , UUID>{
    
    @Query("SELECT c FROM certifications c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationsStudentEntity> findByStudentEmailAndTechnology(String email, String technology);
}
