package com.github.lych.notification.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The enum Email template placeholder.
 */
@Getter
@RequiredArgsConstructor
public enum EmailTemplatePlaceholder {

    /**
     * Code email template placeholder.
     */
    CODE("code");

    private final String value;
}
