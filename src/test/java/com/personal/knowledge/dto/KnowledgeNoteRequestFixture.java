package com.personal.knowledge.dto;

import java.util.List;

import static com.personal.knowledge.util.RandomUtil.generateString;

public class KnowledgeNoteRequestFixture {

    public static KnowledgeNoteRequest build() {

        return new KnowledgeNoteRequest(
                generateString(50),
                generateString(100),
                List.of(generateString(10), generateString(10))
        );
    }
}
