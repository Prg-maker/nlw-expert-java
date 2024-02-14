package com.rockeseat.certificate_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockeseat.certificate_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rockeseat.certificate_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")


public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    
    @PostMapping("/verifyIfHasCertification")
    public String verifyIdHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){
        var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);

        if(result ){
            return "O aluno pode fazer a prova";     
        }
        return "O aluno não pode fazer a prova";     
 
    } 
}
