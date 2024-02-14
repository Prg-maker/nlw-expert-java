package com.rockeseat.certificate_nlw.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockeseat.certificate_nlw.modules.questions.dto.AlternativesResultDTO;
import com.rockeseat.certificate_nlw.modules.questions.dto.QuestionResultDTO;
import com.rockeseat.certificate_nlw.modules.questions.entities.AlternativesEntity;
import com.rockeseat.certificate_nlw.modules.questions.entities.QuestionEntity;
import com.rockeseat.certificate_nlw.modules.questions.repositories.QuestionsRepositories;

@RestController
@RequestMapping("/questions")

public class QuestionsController {

    @Autowired
    private QuestionsRepositories questionRepository;


    @GetMapping("/technology/{technology}")
    
    List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        var result = this.questionRepository.findByTechnology(technology.toUpperCase());

        var toMap = result.stream().map(question -> mapQuestionDto(question)).collect(Collectors.toList());

        return toMap;
    }   


    static QuestionResultDTO mapQuestionDto(QuestionEntity question){
        var questionResultDTO = QuestionResultDTO.builder()
            .id(question.getId())
            .technology(question.getTechnology())
            .description(question.getDescription()).build();
            

        List<AlternativesResultDTO> alternativesResultDTOs = question.getAlternatives()
            .stream().map(alternative -> mapAlternativeDTO(alternative))
                .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTOs);
        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDTO ){
        return AlternativesResultDTO.builder()
            .id(alternativesResultDTO.getId())
            .description(alternativesResultDTO.getDescription()).build();

    } 

}
