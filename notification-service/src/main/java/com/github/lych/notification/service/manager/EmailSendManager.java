package com.github.lych.notification.service.manager;

public interface EmailSendManager {

    void sendRegistrationEmail(String userEmail, String registrationCode);
}
