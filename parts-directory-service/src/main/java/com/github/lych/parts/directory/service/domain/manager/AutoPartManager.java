package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.AutoPart;

import java.util.List;

/**
 * The interface Auto part manager.
 */
public interface AutoPartManager {

    /**
     * Create auto part.
     *
     * @param producerId the producer id
     * @param carsId     the cars id
     * @param autoPart   the auto part
     * @return the auto part
     */
    AutoPart create(String producerId, List<String> carsId, AutoPart autoPart);

    /**
     * Update auto part.
     *
     * @param autoPartId the auto part id
     * @param autoPart   the auto part
     * @return the auto part
     */
    AutoPart update(String autoPartId, AutoPart autoPart);
}
