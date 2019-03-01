package com.github.lych.parts.directory.service.domain.repository;

import com.github.lych.parts.directory.service.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Car}.
 */
public interface CarRepository extends JpaRepository<Car, String> {
}
