package com.github.lych.user.service.domain.service;

import com.github.lych.user.service.domain.common.ParameterValidator;
import com.github.lych.user.service.domain.model.SystemUser;
import com.github.lych.user.service.domain.repository.SystemUserRepository;
import com.github.lych.user.service.domain.exception.ResourceNotFoundServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Base implementation of {@link SystemUserService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseSystemUserService implements SystemUserService {

    private final SystemUserRepository repository;

    @Override
    public SystemUser create(final SystemUser user) {
        ParameterValidator.verifyEntity(user);
        return repository.save(user);
    }

    @Override
    public SystemUser get(final String id) {
        ParameterValidator.verifyIdentifier(id);
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
        ParameterValidator.verifyEntity(user);
        return repository.save(user);
    }

    @Override
    public void delete(final String id) {
        ParameterValidator.verifyIdentifier(id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("System "
                    + "user with id: %s not found.", id));
        }
    }
}
