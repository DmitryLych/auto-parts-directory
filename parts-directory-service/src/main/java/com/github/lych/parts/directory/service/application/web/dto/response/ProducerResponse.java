package com.github.lych.parts.directory.service.application.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Producer response.
 */
@Getter
@Setter
public class ProducerResponse implements Serializable {

    private static final long serialVersionUID = -5399507039150734553L;

    private String id;
    private LocalDateTime createdDate;
    private String name;
    private String address;
    private String email;
}
