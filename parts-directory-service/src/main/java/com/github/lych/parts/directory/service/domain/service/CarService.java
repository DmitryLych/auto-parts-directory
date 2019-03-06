package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.model.Car;

import java.util.List;

/**
 * The interface Car service.
 */
public interface CarService {

    /**
     * Create car.
     *
     * @param car the car
     * @return the car
     */
    Car create(Car car);

    /**
     * Get car.
     *
     * @param id the id
     * @return the car
     */
    Car get(String id);

    /**
     * Get cars by identifiers.
     *
     * @param ids a list of identifiers
     * @return list of cars
     */
    List<Car> getByIds(List<String> ids);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Car> getAll();

    /**
     * Update car.
     *
     * @param car the car
     * @return the car
     */
    Car update(Car car);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);
}
