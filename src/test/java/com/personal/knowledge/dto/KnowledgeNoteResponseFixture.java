package com.personal.knowledge.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.personal.knowledge.util.RandomUtil.generateString;

public class KnowledgeNoteResponseFixture {

    public static KnowledgeNoteResponse build() {
        return new KnowledgeNoteResponse(
                UUID.randomUUID(),
                generateString(50),
                generateString(100),
                List.of(generateString(10), generateString(10)),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
