package com.personal.knowledge.controller;

import com.personal.knowledge.dto.KnowledgeNoteRequest;
import com.personal.knowledge.mapper.KnowledgeMapper;
import com.personal.knowledge.service.KnowledgeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/knowledge-notes")
public class KnowledgeNoteController {

    private final KnowledgeService knowledgeService;
    private final KnowledgeMapper mapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody KnowledgeNoteRequest request) {

        try {
            var note = knowledgeService.createNote(mapper.mapToModel(request));

            return ResponseEntity.created(URI.create("/knowledge-notes/" + note.getId()))
                    .body(mapper.mapToResponse(note));
        } catch (Exception ex) {

            return ResponseEntity.badRequest().body("Error trying to create note: " + ex.getMessage());
        }
    }
}