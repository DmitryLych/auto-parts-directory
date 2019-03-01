package com.github.lych.user.service.domain.exception;

/**
 * Resource not found service exception.
 */
public class ResourceNotFoundServiceException extends RuntimeException {

    private static final long serialVersionUID = -7920499805799155258L;

    public ResourceNotFoundServiceException(final String message) {
        super(message);
    }
}
