package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.Producer;

/**
 * The interface Producer manager.
 */
public interface ProducerManager {

    /**
     * Update producer.
     *
     * @param producerId the producer id
     * @param producer   the producer
     * @return the producer
     */
    Producer update(String producerId, Producer producer);
}
