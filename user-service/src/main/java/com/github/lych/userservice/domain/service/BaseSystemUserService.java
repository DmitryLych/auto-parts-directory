package com.github.lych.userservice.domain.service;

import com.github.lych.userservice.domain.exception.IllegalArgumentServiceException;
import com.github.lych.userservice.domain.exception.ResourceNotFoundServiceException;
import com.github.lych.userservice.domain.model.SystemUser;
import com.github.lych.userservice.domain.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseSystemUserService implements SystemUserService {

    private final SystemUserRepository repository;

    @Override
    public SystemUser create(final SystemUser user) {
        if (isNull(user)) {
            throw new IllegalArgumentServiceException("System user must be not null.");
        }

        return repository.save(user);
    }

    @Override
    public SystemUser get(final String id) {
        if (isBlank(id)) {
            throw new IllegalArgumentServiceException("System user id must be not null.");
        }

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundServiceException(String.format("System "
                + "user with id: %s not found.", id)));
    }

    @Override
    public SystemUser update(final SystemUser user) {
        if (isNull(user)) {
            throw new IllegalArgumentServiceException("System user must be not null.");
        }

        return repository.save(user);
    }

    @Override
    public void delete(final String id) {
        if (isBlank(id)) {
            throw new IllegalArgumentServiceException("System user id must be not null.");
        }

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("System "
                    + "user with id: %s not found.", id));
        }
    }
}
