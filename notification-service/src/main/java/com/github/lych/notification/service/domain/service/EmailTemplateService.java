package com.github.lych.notification.service.domain.service;

import com.github.lych.notification.service.domain.model.EmailTemplate;
import com.github.lych.notification.service.domain.model.EmailTemplateType;

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
