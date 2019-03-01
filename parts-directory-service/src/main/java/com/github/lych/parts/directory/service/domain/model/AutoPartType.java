package com.github.lych.parts.directory.service.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Auto part type.
 */
@Getter
@RequiredArgsConstructor
public enum AutoPartType {

    ENGINE("engine"),

    RUNNING_GEAR("running_gear"),

    BODY("body");

    private final String type;
}
