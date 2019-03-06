package com.github.lych.notification.service.domain.repository;

import com.github.lych.notification.service.domain.model.EmailTemplate;
import com.github.lych.notification.service.domain.model.EmailTemplateType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Email template repository.
 */
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, String> {

    /**
     * Find by type email template.
     *
     * @param type the type
     * @return the email template
     */
    EmailTemplate findByType(EmailTemplateType type);
}
