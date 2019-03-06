package com.github.lych.parts.directory.service.domain.manager;

import com.github.lych.parts.directory.service.domain.model.AutoPart;
import com.github.lych.parts.directory.service.domain.service.AutoPartService;
import com.github.lych.parts.directory.service.domain.service.CarService;
import com.github.lych.parts.directory.service.domain.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyEntity;
import static com.github.lych.parts.directory.service.domain.common.ParameterValidator.verifyIdentifiers;

/**
 * Base implementation of {@link AutoPartManager}.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseAutoPartManager implements AutoPartManager {

    private final ProducerService producerService;
    private final AutoPartService autoPartService;
    private final CarService carService;

    @Override
    public AutoPart create(final String producerId, final List<String> carsId, final AutoPart autoPart) {
        verifyIdentifiers(carsId);
        verifyEntity(autoPart);

        autoPart.setCars(carService.getByIds(carsId));
        autoPart.setProducer(producerService.get(producerId));

        return autoPartService.create(autoPart);
    }

    @Override
    public AutoPart update(final String autoPartId, final AutoPart autoPart) {
        verifyEntity(autoPart);

        autoPart.setId(autoPartId);
        return autoPartService.update(autoPart);
    }
}
