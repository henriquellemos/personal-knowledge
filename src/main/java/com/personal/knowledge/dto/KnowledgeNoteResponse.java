package com.personal.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record KnowledgeNoteResponse(

    UUID id,

    String title,

    String content,

    List<String> tags,

    LocalDateTime createdAt,

    LocalDateTime updatedAt
) {}
