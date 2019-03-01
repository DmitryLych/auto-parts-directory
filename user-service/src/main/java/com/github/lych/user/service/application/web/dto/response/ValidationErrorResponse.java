package com.github.lych.user.service.application.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Validation error response.
 */
@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse implements Serializable {

    private static final long serialVersionUID = -1728850652881388445L;

    private String message;
}
