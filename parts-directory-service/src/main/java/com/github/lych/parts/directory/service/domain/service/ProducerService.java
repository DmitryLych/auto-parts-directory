package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.model.Producer;

import java.util.List;

/**
 * The interface Producer service.
 */
public interface ProducerService {

    /**
     * Create producer.
     *
     * @param producer the producer
     * @return the producer
     */
    Producer create(Producer producer);

    /**
     * Get producer.
     *
     * @param id the id
     * @return the producer
     */
    Producer get(String id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Producer> getAll();

    /**
     * Update producer.
     *
     * @param producer the producer
     * @return the producer
     */
    Producer update(Producer producer);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);
}
