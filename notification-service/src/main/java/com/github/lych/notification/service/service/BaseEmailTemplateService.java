package com.github.lych.notification.service.service;

import com.github.lych.notification.service.exception.IllegalArgumentServiceException;
import com.github.lych.notification.service.model.EmailTemplate;
import com.github.lych.notification.service.model.EmailTemplateType;
import com.github.lych.notification.service.repository.EmailTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseEmailTemplateService implements EmailTemplateService {

    private final EmailTemplateRepository repository;

    @Override
    public EmailTemplate getByType(final EmailTemplateType type) {
        if (isNull(type)) {
            throw new IllegalArgumentServiceException("Email template type must be not null.");
        }

        return repository.findByType(type);
    }
}
