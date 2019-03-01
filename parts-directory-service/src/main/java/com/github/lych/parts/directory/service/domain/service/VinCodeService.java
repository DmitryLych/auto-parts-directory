package com.github.lych.parts.directory.service.domain.service;

import com.github.lych.parts.directory.service.domain.model.VinCode;

import java.util.List;

/**
 * The interface Vin code service.
 */
public interface VinCodeService {

    /**
     * Create vin code.
     *
     * @param vinCode the vin code
     * @return the vin code
     */
    VinCode create(VinCode vinCode);

    /**
     * Get vin code.
     *
     * @param id the id
     * @return the vin code
     */
    VinCode get(String id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<VinCode> getAll();

    /**
     * Update vin code.
     *
     * @param vinCode the vin code
     * @return the vin code
     */
    VinCode update(VinCode vinCode);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);
}
