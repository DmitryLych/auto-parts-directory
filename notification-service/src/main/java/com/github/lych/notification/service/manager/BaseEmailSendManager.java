package com.github.lych.notification.service.manager;

import com.github.lych.notification.service.model.EmailMessage;
import com.github.lych.notification.service.model.EmailTemplate;
import com.github.lych.notification.service.repository.EmailSendRepository;
import com.github.lych.notification.service.service.EmailTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.lych.notification.service.model.EmailTemplatePlaceholder.CODE;
import static com.github.lych.notification.service.model.EmailTemplateType.REGISTRATION;
import static com.github.lych.notification.service.provider.EmailBodyProvider.provideBody;
import static java.util.Collections.singletonMap;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseEmailSendManager implements EmailSendManager {

    private final EmailTemplateService templateService;
    private final EmailSendRepository repository;

    @Override
    public void sendRegistrationEmail(final String userEmail, final String registrationCode) {
        if (isBlank(userEmail) || isBlank(registrationCode)) {
            return;
        }

        final EmailTemplate template = templateService.getByType(REGISTRATION);
        final EmailMessage message = EmailMessage.of(template.getSubject(), provideBody(template.getHtmlBody(),
                singletonMap(CODE, registrationCode)), userEmail);

        repository.sendEmailMessage(message);
    }
}
