package com.personal.knowledge.controller;

import com.personal.knowledge.dto.KnowledgeNoteRequest;
import com.personal.knowledge.dto.KnowledgeNoteRequestFixture;
import com.personal.knowledge.dto.KnowledgeNoteResponse;
import com.personal.knowledge.dto.KnowledgeNoteResponseFixture;
import com.personal.knowledge.mapper.KnowledgeMapper;
import com.personal.knowledge.model.KnowledgeNote;
import com.personal.knowledge.model.KnowledgeNoteFixture;
import com.personal.knowledge.service.KnowledgeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KnowledgeNoteControllerTest {

    @Mock
    private KnowledgeService knowledgeService;

    @Mock
    private KnowledgeMapper mapper;

    @InjectMocks
    private KnowledgeNoteController controller;

    @Test
    void save_shouldReturnCreatedResponse() {
        // given
        KnowledgeNoteRequest request = KnowledgeNoteRequestFixture.build();
        KnowledgeNote note = KnowledgeNoteFixture.build();
        KnowledgeNoteResponse response = KnowledgeNoteResponseFixture.build();

        when(mapper.mapToModel(request)).thenReturn(note);
        when(knowledgeService.createNote(note)).thenReturn(note);
        when(mapper.mapToResponse(note)).thenReturn(response);

        // when
        ResponseEntity<?> result = controller.save(request);

        // then
        assertThat(result.getStatusCode().value()).isEqualTo(201);
        assertThat(result.getBody()).isEqualTo(response);
    }

    @Test
    void save_shouldReturnBadRequestOnException() {
        // given
        KnowledgeNoteRequest request = KnowledgeNoteRequestFixture.build();
        when(mapper.mapToModel(request)).thenThrow(new RuntimeException("Test error"));

        // when
        ResponseEntity<?> result = controller.save(request);

        // then
        assertThat(result.getStatusCode().value()).isEqualTo(400);
        assertThat(result.getBody()).isEqualTo("Error trying to create note: Test error");
    }
}
