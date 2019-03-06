package com.github.lych.parts.directory.service.application.web.controller;

import com.github.lych.parts.directory.service.application.web.dto.request.ProducerRequest;
import com.github.lych.parts.directory.service.application.web.dto.response.ProducerResponse;
import com.github.lych.parts.directory.service.domain.manager.ProducerManager;
import com.github.lych.parts.directory.service.domain.model.Producer;
import com.github.lych.parts.directory.service.domain.service.ProducerService;
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
 * The type Producer controller.
 */
@RestController
@RequestMapping("/api/v1/producers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {

    private final ProducerService service;
    private final ProducerManager manager;
    private final Mapper mapper;

    /**
     * Create response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<ProducerResponse> create(@RequestBody @Valid final ProducerRequest request) {
        final Producer created = service.create(mapper.map(request, Producer.class));
        return ResponseEntity.ok(mapper.map(created, ProducerResponse.class));
    }

    /**
     * Get response entity.
     *
     * @param producerId the producer id
     * @return the response entity
     */
    @GetMapping("/{producerId}")
    public ResponseEntity<ProducerResponse> get(@PathVariable final String producerId) {
        final ProducerResponse response = mapper.map(service.get(producerId), ProducerResponse.class);
        return ResponseEntity.ok(response);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<ProducerResponse>> getAll() {
        final List<ProducerResponse> response = service.getAll().stream()
                .map(producer -> mapper.map(producer, ProducerResponse.class))
                .collect(toList());

        return ResponseEntity.ok(response);
    }

    /**
     * Update response entity.
     *
     * @param producerId the producer id
     * @param request    the request
     * @return the response entity
     */
    @PutMapping("/{producerId}")
    public ResponseEntity<ProducerResponse> update(@PathVariable final String producerId,
                                                   @RequestBody @Valid final ProducerRequest request) {
        final Producer updated = manager.update(producerId, mapper.map(request, Producer.class));
        return ResponseEntity.ok(mapper.map(updated, ProducerResponse.class));
    }

    /**
     * Delete.
     *
     * @param producerId the producer id
     */
    @DeleteMapping("/{producerId}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final String producerId) {
        service.delete(producerId);
    }
}
