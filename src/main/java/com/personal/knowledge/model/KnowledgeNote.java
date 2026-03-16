package com.personal.knowledge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "knowledge_notes")
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeNote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String content;

    @ElementCollection
    @CollectionTable(name = "knowledge_note_tags", joinColumns = @JoinColumn(name = "knowledge_note_id"))
    @Column(name = "tag")
    private List<String> tags;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
