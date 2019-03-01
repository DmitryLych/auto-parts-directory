package com.github.lych.parts.directory.service.domain.repository;

import com.github.lych.parts.directory.service.domain.model.VinCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link VinCode}.
 */
public interface VinCodeRepository extends JpaRepository<VinCode, String> {
}
