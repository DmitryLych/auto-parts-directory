package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.VinCode;
import com.github.lych.parts.directory.service.domain.service.CarService;
import com.github.lych.parts.directory.service.domain.service.VinCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifier;

/**
 * Base implementation of {@link VinCodeManager}.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseVinCodeManager implements VinCodeManager {

    private final VinCodeService vinCodeService;
    private final CarService carService;

    @Override
    public VinCode create(final String carId, final VinCode vinCode) {
        verifyEntity(vinCode);

        vinCode.setCar(carService.get(carId));
        return vinCodeService.create(vinCode);
    }

    @Override
    public VinCode update(final String codeId, final VinCode vinCode) {
        verifyIdentifier(codeId);
        verifyEntity(vinCode);

        vinCode.setId(codeId);
        return vinCodeService.update(vinCode);
    }
}
