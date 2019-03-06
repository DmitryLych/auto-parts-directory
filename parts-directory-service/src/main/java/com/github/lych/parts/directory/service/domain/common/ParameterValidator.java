package com.github.lych.parts.directory.service.domain.common;

import com.github.lych.parts.directory.service.domain.exception.IllegalArgumentServiceException;
import com.github.lych.parts.directory.service.domain.model.AbstractEntity;

import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Parameter validator.
 */
public final class ParameterValidator {

    private ParameterValidator() {
        // avoid implementation
    }

    /**
     * Verify identifier.
     *
     * @param id a identifier
     */
    public static void verifyIdentifier(final String id) {
        if (isBlank(id)) {
            throw new IllegalArgumentServiceException("Identifier must be not null.");
        }
    }

    /**
     * Verify identifiers.
     *
     * @param ids a identifiers
     */
    public static void verifyIdentifiers(final List<String> ids) {
        ids.forEach(ParameterValidator::verifyIdentifier);
    }

    /**
     * Verify entity.
     *
     * @param entity a entity
     */
    public static void verifyEntity(final AbstractEntity entity) {
        if (isNull(entity)) {
            throw new IllegalArgumentServiceException("Entity must be not null.");
        }
    }
}
