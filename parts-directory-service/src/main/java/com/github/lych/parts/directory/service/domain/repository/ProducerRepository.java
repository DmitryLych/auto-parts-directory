package com.github.lych.parts.directory.service.domain.repository;

import com.github.lych.parts.directory.service.domain.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Producer}.
 */
public interface ProducerRepository extends JpaRepository<Producer, String> {
}
