package com.github.lych.parts.directory.service.domain.exception;

/**
 * Resource not found service exception.
 */
public class ResourceNotFoundServiceException extends RuntimeException {

    private static final long serialVersionUID = 7018105737713006585L;

    public ResourceNotFoundServiceException(final String message) {
        super(message);
    }
}
