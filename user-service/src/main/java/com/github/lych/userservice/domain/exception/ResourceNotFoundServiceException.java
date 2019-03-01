package com.github.lych.userservice.domain.exception;

public class ResourceNotFoundServiceException extends RuntimeException {

    public ResourceNotFoundServiceException(final String message) {
        super(message);
    }
}
