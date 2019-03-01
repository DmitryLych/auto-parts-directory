package com.github.lych.parts.directory.service.domain.exception;

/**
 * Illegal argument service exception.
 */
public class IllegalArgumentServiceException extends RuntimeException {

    private static final long serialVersionUID = 5163963138111060510L;

    public IllegalArgumentServiceException(final String message) {
        super(message);
    }
}
