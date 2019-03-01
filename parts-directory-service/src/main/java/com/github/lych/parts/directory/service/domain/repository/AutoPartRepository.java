package com.github.lych.parts.directory.service.domain.repository;

import com.github.lych.parts.directory.service.domain.model.AutoPart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link AutoPart}.
 */
public interface AutoPartRepository extends JpaRepository<AutoPart, String> {
}
