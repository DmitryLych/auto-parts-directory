package com.github.lych.userservice.application.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Error response.
 */
@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -2803115593118594167L;

    private String message;
    private List<ValidationErrorResponse> errors;
}
