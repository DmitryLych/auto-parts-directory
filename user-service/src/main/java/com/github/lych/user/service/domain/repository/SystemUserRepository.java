package com.github.lych.user.service.domain.repository;

import com.github.lych.user.service.domain.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link SystemUser}.
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, String> {

}
