package com.personal.knowledge.model;

import java.util.UUID;

import static com.personal.knowledge.util.RandomUtil.generateString;

public class KnowledgeNoteFixture {

    public static KnowledgeNote build() {

        return builder().build();
    }

    private static KnowledgeNote.KnowledgeNoteBuilder builder() {

        return KnowledgeNote.builder()
                .id(UUID.randomUUID())
                .title(generateString(50));
    }
}
