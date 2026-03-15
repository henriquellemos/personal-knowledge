package com.personal.knowledge.service;

import com.personal.knowledge.model.KnowledgeNote;
import com.personal.knowledge.model.KnowledgeNoteFixture;
import com.personal.knowledge.repository.KnowledgeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KnowledgeServiceTest {

    @Mock
    private KnowledgeRepository repository;

    @InjectMocks
    private KnowledgeService service;

    @Test
    void createNote_shouldSaveAndReturnNote() {
        // given
        KnowledgeNote note = KnowledgeNoteFixture.build();

        when(repository.save(note)).thenReturn(note);

        // when
        KnowledgeNote result = service.createNote(note);

        // then
        assertThat(result).isEqualTo(note);
        verify(repository).save(note);
    }
}