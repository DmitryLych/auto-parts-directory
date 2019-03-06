package com.github.lych.parts.directory.service.application.web.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Field error response.
 */
@Getter
@Setter
public class FieldErrorResponse extends ValidationErrorResponse {

    private static final long serialVersionUID = 4034312561054830328L;

    private String fieldName;
    private Object fieldValue;

    /**
     * Instantiates a new Field error response.
     *
     * @param message    the message
     * @param fieldName  the field name
     * @param fieldValue the field value
     */
    public FieldErrorResponse(final String message,
                              final String fieldName,
                              final Object fieldValue) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
