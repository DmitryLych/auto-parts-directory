package com.github.lych.notification.service.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public final class EmailMessage {

    private final String subject;
    private final String body;
    private final String receiver;
}
