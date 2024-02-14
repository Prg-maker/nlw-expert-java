package com.rockeseat.certificate_nlw.modules.questions.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResultDTO{
    private UUID id;    
    private String technology;
    private String description;

    private List<AlternativesResultDTO> alternatives;

}
