package com.github.lych.notification.service.domain.exception;

/**
 * The type Illegal argument service exception.
 */
public class IllegalArgumentServiceException extends RuntimeException {

    private static final long serialVersionUID = 7467366340344857458L;

    /**
     * Instantiates a new Illegal argument service exception.
     *
     * @param message the message
     */
    public IllegalArgumentServiceException(final String message) {
        super(message);
    }
}
