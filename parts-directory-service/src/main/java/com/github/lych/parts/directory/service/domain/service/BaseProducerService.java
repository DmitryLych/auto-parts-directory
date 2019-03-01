package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.exception.ResourceNotFoundServiceException;
import com.github.lych.parts.directory.service.domain.model.Producer;
import com.github.lych.parts.directory.service.domain.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link ProducerService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseProducerService implements ProducerService {

    private final ProducerRepository repository;

    @Override
    public Producer create(final Producer producer) {
        verifyEntity(producer);
        return repository.save(producer);
    }

    @Override
    public Producer get(final String id) {
        verifyIdentifier(id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundServiceException(String.format("Producer with id: %s not"
                        + " found.", id)));
    }

    @Override
    public List<Producer> getAll() {
        return repository.findAll();
    }

    @Override
    public Producer update(final Producer producer) {
        verifyEntity(producer);
        return repository.save(producer);
    }

    @Override
    public void delete(final String id) {
        verifyIdentifier(id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("Producer with id: %s not found.", id));
        }
    }
}
