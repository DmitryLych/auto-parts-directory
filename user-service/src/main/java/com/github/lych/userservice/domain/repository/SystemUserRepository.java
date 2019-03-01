package com.github.lych.userservice.domain.repository;

import com.github.lych.userservice.domain.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, String> {

}
