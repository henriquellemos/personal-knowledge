package com.personal.knowledge.mapper;

import com.personal.knowledge.dto.KnowledgeNoteRequest;
import com.personal.knowledge.dto.KnowledgeNoteResponse;
import com.personal.knowledge.model.KnowledgeNote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KnowledgeMapper {

    KnowledgeNoteResponse mapToResponse(KnowledgeNote note);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    KnowledgeNote mapToModel(KnowledgeNoteRequest request);
}