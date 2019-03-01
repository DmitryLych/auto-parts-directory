package com.github.lych.user.service.application.web.dto.response;

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

    public FieldErrorResponse(final String message,
                              final String fieldName,
                              final Object fieldValue) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
