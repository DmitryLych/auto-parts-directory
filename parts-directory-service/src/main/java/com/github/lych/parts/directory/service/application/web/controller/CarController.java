package com.github.lych.parts.directory.service.application.web.controller;

import com.github.lych.parts.directory.service.application.web.dto.request.CarRequest;
import com.github.lych.parts.directory.service.application.web.dto.response.CarResponse;
import com.github.lych.parts.directory.service.domain.manager.CarManager;
import com.github.lych.parts.directory.service.domain.model.Car;
import com.github.lych.parts.directory.service.domain.service.CarService;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * The type Car controller.
 */
@RestController
@RequestMapping("/api/v1/producers/{producerId}/cars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {

    private final CarManager manager;
    private final CarService service;
    private final Mapper mapper;

    /**
     * Create response entity.
     *
     * @param producerId the producer id
     * @param request    the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<CarResponse> create(@PathVariable final String producerId,
                                              @RequestBody @Valid final CarRequest request) {
        final Car createdCar = manager.create(producerId, mapper.map(request, Car.class));
        return ResponseEntity.ok(mapper.map(createdCar, CarResponse.class));
    }

    /**
     * Get response entity.
     *
     * @param carId the car id
     * @return the response entity
     */
    @GetMapping("/{carId}")
    public ResponseEntity<CarResponse> get(@PathVariable final String carId) {
        final CarResponse response = mapper.map(service.get(carId), CarResponse.class);
        return ResponseEntity.ok(response);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<CarResponse>> getAll() {
        final List<CarResponse> responses = service.getAll().stream()
                .map(car -> mapper.map(car, CarResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    /**
     * Update response entity.
     *
     * @param carId   the car id
     * @param request the request
     * @return the response entity
     */
    @PutMapping("/{carId}")
    public ResponseEntity<CarResponse> update(@PathVariable final String carId,
                                              @RequestBody @Valid final CarRequest request) {
        final Car updatedCar = manager.update(carId, mapper.map(request, Car.class));
        return ResponseEntity.ok(mapper.map(updatedCar, CarResponse.class));
    }

    /**
     * Delete.
     *
     * @param carId the car id
     */
    @DeleteMapping("/{carId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final String carId) {
        service.delete(carId);
    }
}
