package com.github.lych.notification.service.domain.repository;

import com.github.lych.notification.service.domain.model.EmailMessage;

/**
 * The interface Send repository.
 */
public interface EmailSendRepository {

    /**
     * Send email message.
     *
     * @param message the message
     */
    void sendEmailMessage(EmailMessage message);
}
