package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.Car;

public interface CarManager {

    Car create(String producerId, Car car);
}
