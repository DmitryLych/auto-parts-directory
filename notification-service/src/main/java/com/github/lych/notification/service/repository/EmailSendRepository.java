package com.github.lych.notification.service.repository;

import com.github.lych.notification.service.model.EmailMessage;

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
