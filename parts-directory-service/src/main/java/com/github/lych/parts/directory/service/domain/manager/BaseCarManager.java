package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.Car;
import com.github.lych.parts.directory.service.domain.service.CarService;
import com.github.lych.parts.directory.service.domain.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link CarManager}.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseCarManager implements CarManager {

    private final ProducerService producerService;
    private final CarService carService;

    @Override
    public Car create(final String producerId, final Car car) {
        verifyEntity(car);

        car.setProducer(producerService.get(producerId));
        return carService.create(car);
    }

    @Override
    public Car update(final String carId, final Car car) {
        verifyIdentifier(carId);
        verifyEntity(car);

        car.setId(carId);
        return carService.update(car);
    }
}
