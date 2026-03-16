CREATE TABLE knowledge_notes (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE knowledge_note_tags (
    knowledge_note_id UUID NOT NULL,
    tag VARCHAR(255) NOT NULL,
    FOREIGN KEY (knowledge_note_id) REFERENCES knowledge_notes(id)
);
