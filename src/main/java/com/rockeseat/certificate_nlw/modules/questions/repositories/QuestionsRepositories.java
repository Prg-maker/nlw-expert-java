package com.rockeseat.certificate_nlw.modules.questions.repositories;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockeseat.certificate_nlw.modules.questions.entities.QuestionEntity;

public interface QuestionsRepositories extends JpaRepository<QuestionEntity, UUID> {
    List<QuestionEntity> findByTechnology(String technology);
}
