package com.github.lych.userservice.domain.repository;

import com.github.lych.userservice.domain.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link SystemUser}.
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, String> {

}
