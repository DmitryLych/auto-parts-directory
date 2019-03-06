package com.github.lych.notification.service.provider;

import com.github.lych.notification.service.model.EmailTemplatePlaceholder;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public final class EmailBodyProvider {

    private EmailBodyProvider() {

    }

    public static String provideBody(final String templateBody, final Map<EmailTemplatePlaceholder, String> params) {
        String result = templateBody;

        for (final Map.Entry<EmailTemplatePlaceholder, String> entry : params.entrySet()) {
            result = result.replace("{" + entry.getKey().getValue() + "}", prepareValue(entry.getValue()));
        }
        return result;
    }

    private static String prepareValue(final String value) {
        return StringUtils.isBlank(value) ? "" : value;
    }
}
