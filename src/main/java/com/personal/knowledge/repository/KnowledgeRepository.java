package com.personal.knowledge.repository;

import com.personal.knowledge.model.KnowledgeNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KnowledgeRepository extends JpaRepository<KnowledgeNote, UUID> {}