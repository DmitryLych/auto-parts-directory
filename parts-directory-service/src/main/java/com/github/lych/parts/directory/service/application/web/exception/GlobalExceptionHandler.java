package com.github.lych.parts.directory.service.application.web.exception;

import com.github.lych.parts.directory.service.application.web.dto.response.ErrorResponse;
import com.github.lych.parts.directory.service.application.web.dto.response.FieldErrorResponse;
import com.github.lych.parts.directory.service.application.web.dto.response.ValidationErrorResponse;
import com.github.lych.parts.directory.service.domain.exception.IllegalArgumentServiceException;
import com.github.lych.parts.directory.service.domain.exception.ResourceNotFoundServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Global exception handler.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String VALIDATION_ERROR_MESSAGE = "Error occurred during validation";

    /**
     * Handle illegal argument service exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(IllegalArgumentServiceException.class)
    public ResponseEntity handleIllegalArgumentServiceException(final IllegalArgumentServiceException exception) {
        log.warn(exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    /**
     * Handle illegal argument service exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(ResourceNotFoundServiceException.class)
    public ResponseEntity handleIllegalArgumentServiceException(final ResourceNotFoundServiceException exception) {
        log.warn(exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    /**
     * Handle javax validation {@link MethodArgumentNotValidException}.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        log.warn("Processing validation exception: {}", exception.getClass().getSimpleName(), exception);

        final List<ValidationErrorResponse> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(objectError -> {
                    if (objectError instanceof FieldError) {
                        final String field = ((FieldError) objectError).getField();
                        final Object rejectedValue = ((FieldError) objectError).getRejectedValue();

                        return new FieldErrorResponse(field, objectError.getDefaultMessage(), rejectedValue);
                    } else {
                        return new ValidationErrorResponse(objectError.getDefaultMessage());
                    }
                }).collect(toList());

        return ResponseEntity.badRequest().body(new ErrorResponse(VALIDATION_ERROR_MESSAGE, errors));
    }
}
