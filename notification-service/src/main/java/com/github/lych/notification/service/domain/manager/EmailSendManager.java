package com.github.lych.notification.service.domain.manager;

public interface EmailSendManager {

    void sendRegistrationEmail(String userEmail, String registrationCode);
}
