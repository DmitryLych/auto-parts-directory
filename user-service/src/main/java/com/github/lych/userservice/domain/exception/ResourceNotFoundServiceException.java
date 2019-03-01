package com.github.lych.userservice.domain.exception;

/**
 * Resource not found service exception.
 */
public class ResourceNotFoundServiceException extends RuntimeException {

    public ResourceNotFoundServiceException(final String message) {
        super(message);
    }
}
