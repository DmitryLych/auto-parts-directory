package com.github.lych.notification.service.service;

import com.github.lych.notification.service.model.EmailTemplate;
import com.github.lych.notification.service.model.EmailTemplateType;

/**
 * The interface Email template service.
 */
public interface EmailTemplateService {

    /**
     * Gets by type.
     *
     * @param type the type
     * @return {@link EmailTemplate}
     */
    EmailTemplate getByType(EmailTemplateType type);
}
