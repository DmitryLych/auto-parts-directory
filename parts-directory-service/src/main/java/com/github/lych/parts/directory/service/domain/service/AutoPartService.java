package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.model.AutoPart;

import java.util.List;

/**
 * Service for {@link AutoPart}.
 */
public interface AutoPartService {

    /**
     * Create new {@link AutoPart}.
     *
     * @param autoPart the auto part
     * @return auto part
     */
    AutoPart create(AutoPart autoPart);

    /**
     * Get auto part.
     *
     * @param id the id
     * @return the auto part
     */
    AutoPart get(String id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<AutoPart> getAll();

    /**
     * Update auto part.
     *
     * @param autoPart the auto part
     * @return the auto part
     */
    AutoPart update(AutoPart autoPart);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);
}
