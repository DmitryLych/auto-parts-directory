package com.github.lych.notification.service.repository;

import com.github.lych.notification.service.config.EmailConfig;
import com.github.lych.notification.service.model.EmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Objects;
import java.util.Properties;

import static javax.mail.internet.InternetAddress.parse;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseEmailSendRepository implements EmailSendRepository {

    private static final String MESSAGE_CONTENT_TYPE = "text/html; charset=utf-8";

    private final Properties mailProperties;
    private final EmailConfig.MailAuthenticator mailAuthenticator;

    @Value("${mail.user.email-address}")
    private String from;

    @Override
    public void sendEmailMessage(final EmailMessage message) {
        if (Objects.nonNull(message)) {
            try {
                log.debug(String.format("Sending email message to receiver: %s", message.getReceiver()));
                Transport.send(buildEmailMessage(message));
            } catch (MessagingException exception) {
                log.warn("Emails for receiver: '" + message.getReceiver() + "' were not sent", exception);
            }
        }
    }

    private Message buildEmailMessage(final EmailMessage message) throws MessagingException {
        return prepareFinalMessage(prepareContent(message.getBody()), message.getSubject(), message.getReceiver());
    }

    private Multipart prepareContent(final String body) throws MessagingException {
        final MimeBodyPart messagePart = new MimeBodyPart();
        messagePart.setContent(body, MESSAGE_CONTENT_TYPE);
        return new MimeMultipart(messagePart);
    }

    private MimeMessage prepareFinalMessage(final Multipart multipart, final String subject,
                                            final String receiver) throws MessagingException {
        final MimeMessage finalMessage = new MimeMessage(Session.getInstance(mailProperties, mailAuthenticator));

        finalMessage.setFrom(new InternetAddress(from));
        finalMessage.setRecipients(Message.RecipientType.TO, parse(receiver));
        finalMessage.setSubject(subject);
        finalMessage.setContent(multipart);

        return finalMessage;
    }
}
