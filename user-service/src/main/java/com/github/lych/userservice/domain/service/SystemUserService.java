package com.github.lych.userservice.domain.service;

import com.github.lych.userservice.domain.model.SystemUser;

public interface SystemUserService {

    SystemUser create(SystemUser user);

    SystemUser get(String id);

    SystemUser update(SystemUser user);

    void delete(String id);
}
