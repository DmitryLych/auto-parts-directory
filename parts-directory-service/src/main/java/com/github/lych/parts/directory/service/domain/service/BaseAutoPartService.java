package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.exception.ResourceNotFoundServiceException;
import com.github.lych.parts.directory.service.domain.model.AutoPart;
import com.github.lych.parts.directory.service.domain.repository.AutoPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link AutoPartService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseAutoPartService implements AutoPartService {

    private final AutoPartRepository repository;

    @Override
    public AutoPart create(final AutoPart autoPart) {
        verifyEntity(autoPart);
        return repository.save(autoPart);
    }

    @Override
    public AutoPart get(final String id) {
        verifyIdentifier(id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundServiceException(String.format("Auto part with id: %s not"
                        + " found.", id)));
    }

    @Override
    public List<AutoPart> getAll() {
        return repository.findAll();
    }

    @Override
    public AutoPart update(final AutoPart autoPart) {
        verifyEntity(autoPart);
        return repository.save(autoPart);
    }

    @Override
    public void delete(final String id) {
        verifyIdentifier(id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("Auto part with id: %s not found.", id));
        }
    }
}
