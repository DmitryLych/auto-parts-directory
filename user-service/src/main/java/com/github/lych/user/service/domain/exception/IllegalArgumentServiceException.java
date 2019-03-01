package com.github.lych.user.service.domain.exception;

/**
 * Illegal argument service exception.
 */
public class IllegalArgumentServiceException extends RuntimeException {

    private static final long serialVersionUID = 1936603732421116631L;

    public IllegalArgumentServiceException(final String message) {
        super(message);
    }
}
