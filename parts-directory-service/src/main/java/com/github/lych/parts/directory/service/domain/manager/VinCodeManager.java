package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.VinCode;

/**
 * The interface Vin code manager.
 */
public interface VinCodeManager {

    /**
     * Create vin code.
     *
     * @param carId   the car id
     * @param vinCode the vin code
     * @return the vin code
     */
    VinCode create(String carId, VinCode vinCode);

    /**
     * Update vin code.
     *
     * @param codeId  the code id
     * @param vinCode the vin code
     * @return the vin code
     */
    VinCode update(String codeId, VinCode vinCode);
}
