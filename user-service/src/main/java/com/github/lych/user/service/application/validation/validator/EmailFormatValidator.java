package com.github.lych.user.service.application.validation.validator;

import com.github.lych.user.service.application.validation.annotation.CorrectEmailFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Validator for {@link CorrectEmailFormat}.
 */
public class EmailFormatValidator implements ConstraintValidator<CorrectEmailFormat, String> {

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        return isNotBlank(value) && isCorrectValue(value);
    }

    private boolean isCorrectValue(final String value) {
        return compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(value).matches();
    }
}
