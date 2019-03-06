package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.Car;

/**
 * Car manager.
 */
public interface CarManager {

    /**
     * Create new Car.
     *
     * @param producerId a producer id
     * @param car        a car
     * @return created car
     */
    Car create(String producerId, Car car);

    /**
     * Update car.
     *
     * @param carId a car id
     * @param car   the car
     * @return the car
     */
    Car update(String carId, Car car);

}
