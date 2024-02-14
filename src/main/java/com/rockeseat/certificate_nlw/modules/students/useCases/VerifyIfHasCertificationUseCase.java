package com.rockeseat.certificate_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.rockeseat.certificate_nlw.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase{
    

    public boolean execute(VerifyHasCertificationDTO dto){
        if(dto.getEmail().equals("john@example.org") && dto.getTechnology().toLowerCase().equals("java")){
            return true;
        }
        return false;
    }
}