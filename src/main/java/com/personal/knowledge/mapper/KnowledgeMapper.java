package com.personal.knowledge.mapper;

import com.personal.knowledge.dto.KnowledgeNoteResponse;
import com.personal.knowledge.model.KnowledgeNote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KnowledgeMapper {

    KnowledgeNoteResponse mapToResponse(KnowledgeNote note);
}