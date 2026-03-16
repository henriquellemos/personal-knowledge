package com.personal.knowledge.dto;

import java.util.List;

public record KnowledgeNoteRequest(

    String title,

    String content,

    List<String> tags
) {}
