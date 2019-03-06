package com.github.lych.parts.directory.service.application.web.controller;

import com.github.lych.parts.directory.service.application.web.dto.request.AutoPartRequest;
import com.github.lych.parts.directory.service.application.web.dto.response.AutoPartResponse;
import com.github.lych.parts.directory.service.domain.manager.AutoPartManager;
import com.github.lych.parts.directory.service.domain.model.AutoPart;
import com.github.lych.parts.directory.service.domain.service.AutoPartService;
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

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * The type Auto part controller.
 */
@RestController
@RequestMapping("/api/v1/producers/{producerId}/auto-parts")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutoPartController {

    private final AutoPartService service;
    private final AutoPartManager manager;
    private final Mapper mapper;

    /**
     * Create response entity.
     *
     * @param producerId the producer id
     * @param request    the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<AutoPartResponse> create(@PathVariable final String producerId,
                                                   @RequestBody final AutoPartRequest request) {
        final AutoPart created = manager.create(producerId, request.getCarsId(), mapper.map(request, AutoPart.class));
        return ResponseEntity.ok(mapper.map(created, AutoPartResponse.class));
    }

    /**
     * Get response entity.
     *
     * @param autoPartId the auto part id
     * @return the response entity
     */
    @GetMapping("/{autoPartId}")
    public ResponseEntity<AutoPartResponse> get(@PathVariable final String autoPartId) {
        final AutoPartResponse response = mapper.map(service.get(autoPartId), AutoPartResponse.class);
        return ResponseEntity.ok(response);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<AutoPartResponse>> getAll() {
        final List<AutoPartResponse> response = service.getAll().stream()
                .map(part -> mapper.map(part, AutoPartResponse.class))
                .collect(toList());

        return ResponseEntity.ok(response);
    }

    /**
     * Update response entity.
     *
     * @param autoPartId the auto part id
     * @param request    the request
     * @return the response entity
     */
    @PutMapping("/{autoPartId}")
    public ResponseEntity<AutoPartResponse> update(@PathVariable final String autoPartId,
                                                   @RequestBody final AutoPartRequest request) {
        final AutoPart updated = manager.update(autoPartId, mapper.map(request, AutoPart.class));
        return ResponseEntity.ok(mapper.map(updated, AutoPartResponse.class));
    }

    /**
     * Delete.
     *
     * @param autoPartId the auto part id
     */
    @DeleteMapping("/{autoPartId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final String autoPartId) {
        service.delete(autoPartId);
    }
}
