package com.github.lych.user.service.application.validation.annotation;

import com.github.lych.user.service.application.validation.validator.EmailFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for email format verification.
 */
@Documented
@Constraint(validatedBy = EmailFormatValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectEmailFormat {

    /**
     * Exception message.
     *
     * @return the exception message.
     */
    String message() default "Incorrect email format.";

    /**
     * Groups.
     *
     * @return groups
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     *
     * @return the payload
     */
    Class<? extends Payload>[] payload() default {};
}
