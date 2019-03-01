package com.github.lych.userservice.domain.exception;

/**
 * Illegal argument service exception.
 */
public class IllegalArgumentServiceException extends RuntimeException {

    public IllegalArgumentServiceException(final String message) {
        super(message);
    }
}
