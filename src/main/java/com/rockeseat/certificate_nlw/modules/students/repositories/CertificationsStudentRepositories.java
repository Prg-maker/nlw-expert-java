package com.rockeseat.certificate_nlw.modules.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rockeseat.certificate_nlw.modules.students.entities.CertificationsStudentEntity;

import java.util.UUID;


public interface  CertificationsStudentRepositories extends JpaRepository<CertificationsStudentEntity , UUID>{
    
}
