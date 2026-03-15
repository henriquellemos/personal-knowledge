package com.personal.knowledge.service;

import com.personal.knowledge.model.KnowledgeNote;
import com.personal.knowledge.repository.KnowledgeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KnowledgeService {

    private final KnowledgeRepository repository;

    public KnowledgeNote createNote(KnowledgeNote note) {

        log.info("Creating note: {}", note);
        return repository.save(note);
    }
}