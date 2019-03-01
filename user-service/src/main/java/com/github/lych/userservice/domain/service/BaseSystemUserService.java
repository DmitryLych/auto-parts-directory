package com.github.lych.userservice.domain.service;

import com.github.lych.userservice.domain.exception.ResourceNotFoundServiceException;
import com.github.lych.userservice.domain.model.SystemUser;
import com.github.lych.userservice.domain.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.lych.userservice.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.userservice.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link SystemUserService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseSystemUserService implements SystemUserService {

    private final SystemUserRepository repository;

    @Override
    public SystemUser create(final SystemUser user) {
        verifyEntity(user);
        return repository.save(user);
    }

    @Override
    public SystemUser get(final String id) {
        verifyIdentifier(id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundServiceException(String.format("System user with id: %s"
                        + " not found.", id)));
    }

    @Override
    public List<SystemUser> getAll() {
        return repository.findAll();
    }

    @Override
    public SystemUser update(final SystemUser user) {
        verifyEntity(user);
        return repository.save(user);
    }

    @Override
    public void delete(final String id) {
        verifyIdentifier(id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("System "
                    + "user with id: %s not found.", id));
        }
    }
}
