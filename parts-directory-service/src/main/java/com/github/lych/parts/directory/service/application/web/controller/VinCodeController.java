package com.github.lych.parts.directory.service.application.web.controller;

import com.github.lych.parts.directory.service.application.web.dto.request.VinCodeRequest;
import com.github.lych.parts.directory.service.application.web.dto.response.VinCodeResponse;
import com.github.lych.parts.directory.service.domain.manager.VinCodeManager;
import com.github.lych.parts.directory.service.domain.model.VinCode;
import com.github.lych.parts.directory.service.domain.service.VinCodeService;
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

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * The type Vin code controller.
 */
@RestController
@RequestMapping("/api/v1/producers/{producerId}/cars/{carId}/vin-codes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VinCodeController {

    private final VinCodeService service;
    private final VinCodeManager manager;
    private final Mapper mapper;

    /**
     * Create response entity.
     *
     * @param carId   the car id
     * @param request the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<VinCodeResponse> create(@PathVariable final String carId,
                                                  @RequestBody @Valid final VinCodeRequest request) {
        final VinCode createdCode = manager.create(carId, mapper.map(request, VinCode.class));
        return ResponseEntity.ok(mapper.map(createdCode, VinCodeResponse.class));
    }

    /**
     * Get response entity.
     *
     * @param vinCodeId the vin code id
     * @return the response entity
     */
    @GetMapping("/{vinCodeId}")
    public ResponseEntity<VinCodeResponse> get(@PathVariable final String vinCodeId) {
        final VinCode code = service.get(vinCodeId);
        return ResponseEntity.ok(mapper.map(code, VinCodeResponse.class));
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<VinCodeResponse>> getAll() {
        final List<VinCodeResponse> response = service.getAll().stream()
                .map(code -> mapper.map(code, VinCodeResponse.class))
                .collect(toList());

        return ResponseEntity.ok(response);
    }

    /**
     * Update response entity.
     *
     * @param vinCodeId the vin code id
     * @param request   the request
     * @return the response entity
     */
    @PutMapping("/{vinCodeId}")
    public ResponseEntity<VinCodeResponse> update(@PathVariable final String vinCodeId,
                                                  @RequestBody @Valid final VinCodeRequest request) {
        final VinCode createdCode = manager.update(vinCodeId, mapper.map(request, VinCode.class));
        return ResponseEntity.ok(mapper.map(createdCode, VinCodeResponse.class));
    }

    /**
     * Delete.
     *
     * @param vinCodeId the vin code id
     */
    @DeleteMapping("/{vinCodeId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final String vinCodeId) {
        service.delete(vinCodeId);
    }
}
