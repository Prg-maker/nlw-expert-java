package com.rockeseat.certificate_nlw.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockeseat.certificate_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rockeseat.certificate_nlw.modules.students.repositories.CertificationsStudentRepositories;

@Service
public class VerifyIfHasCertificationUseCase{
    
    @Autowired
    private CertificationsStudentRepositories certificationsStudentRepositories;

    public boolean execute(VerifyHasCertificationDTO dto){
        var result = certificationsStudentRepositories.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
}