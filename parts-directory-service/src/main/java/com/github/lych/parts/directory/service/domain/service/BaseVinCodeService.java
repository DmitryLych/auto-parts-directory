package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.exception.ResourceNotFoundServiceException;
import com.github.lych.parts.directory.service.domain.model.VinCode;
import com.github.lych.parts.directory.service.domain.repository.VinCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link VinCodeService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseVinCodeService implements VinCodeService {

    private final VinCodeRepository repository;

    @Override
    public VinCode create(final VinCode vinCode) {
        verifyEntity(vinCode);
        return repository.save(vinCode);
    }

    @Override
    public VinCode get(final String id) {
        verifyIdentifier(id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundServiceException(String.format("Vin code with id: %s not"
                        + " found.", id)));
    }

    @Override
    public List<VinCode> getAll() {
        return repository.findAll();
    }

    @Override
    public VinCode update(final VinCode vinCode) {
        verifyEntity(vinCode);
        return repository.save(vinCode);
    }

    @Override
    public void delete(final String id) {
        verifyIdentifier(id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("Vin code with id: %s not found.", id));
        }
    }
}
