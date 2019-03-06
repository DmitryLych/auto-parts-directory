package com.github.lych.notification.service.domain.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Configuration
public class EmailConfig {

    /**
     * Creates {@link MailAuthenticator} bean.
     *
     * @param emailAddress the system email address
     * @param password     the password
     * @return the mail authenticator
     */
    @Bean
    public MailAuthenticator authenticator(@Value("${mail.user.email-address}") final String emailAddress,
                                           @Value("${mail.user.email-password}") final String password) {
        return new MailAuthenticator(new PasswordAuthentication(emailAddress, password));
    }

    /**
     * The type Mail authenticator.
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class MailAuthenticator extends Authenticator {
        @Getter(AccessLevel.PROTECTED)
        private final PasswordAuthentication passwordAuthentication;
    }
}
