package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.Producer;
import com.github.lych.parts.directory.service.domain.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link ProducerManager}.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseProducerManager implements ProducerManager {

    private final ProducerService service;

    @Override
    public Producer update(final String producerId, final Producer producer) {
        verifyIdentifier(producerId);
        verifyEntity(producer);

        producer.setId(producerId);
        return service.update(producer);
    }
}
