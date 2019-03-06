package com.github.lych.parts.directory.service.application.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Car response.
 */
@Getter
@Setter
public class CarResponse implements Serializable {

    private static final long serialVersionUID = -1051779803547201922L;

    private String id;
    private LocalDateTime createdDate;
    private String make;
    private String model;
    private LocalDate startProduction;
    private LocalDate endProduction;
}
