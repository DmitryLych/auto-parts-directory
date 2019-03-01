package com.github.lych.userservice.domain.common;

import com.github.lych.userservice.domain.exception.IllegalArgumentServiceException;
import com.github.lych.userservice.domain.model.SystemUser;

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
            throw new IllegalArgumentServiceException("System user id must be not null.");
        }
    }

    /**
     * Verify entity.
     *
     * @param user a entity
     */
    public static void verifyEntity(final SystemUser user) {
        if (isNull(user)) {
            throw new IllegalArgumentServiceException("System user must be not null.");
        }
    }
}
