package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.exception.ResourceNotFoundServiceException;
import com.github.lych.parts.directory.service.domain.model.Car;
import com.github.lych.parts.directory.service.domain.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link CarService}.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseCarService implements CarService {

    private final CarRepository repository;

    @Override
    public Car create(final Car car) {
        verifyEntity(car);
        return repository.save(car);
    }

    @Override
    public Car get(final String id) {
        verifyIdentifier(id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundServiceException(String.format("Car with id: %s not"
                        + " found.", id)));
    }

    @Override
    public List<Car> getAll() {
        return repository.findAll();
    }

    @Override
    public Car update(final Car car) {
        verifyEntity(car);
        return repository.save(car);
    }

    @Override
    public void delete(final String id) {
        verifyIdentifier(id);

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundServiceException(String.format("Car with id: %s not found.", id));
        }
    }
}
