package com.github.lych.parts.directory.service.application.web.controller;

import com.github.lych.parts.directory.service.application.web.dto.request.CarRequest;
import com.github.lych.parts.directory.service.application.web.dto.response.CarResponse;
import com.github.lych.parts.directory.service.domain.manager.CarManager;
import com.github.lych.parts.directory.service.domain.model.Car;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/producers/{producerId}/cars")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {

    private final CarManager manager;
    private final Mapper mapper;

    @PostMapping
    public ResponseEntity<CarResponse> create(@PathVariable final String producerId,
                                              @RequestBody @Valid final CarRequest request) {
        final Car createdCar = manager.create(producerId, mapper.map(request, Car.class));
        return ResponseEntity.ok(mapper.map(createdCar, CarResponse.class));
    }
}
