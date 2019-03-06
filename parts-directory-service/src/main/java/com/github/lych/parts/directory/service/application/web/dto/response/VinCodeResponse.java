package com.github.lych.parts.directory.service.application.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Vin code response.
 */
@Getter
@Setter
public class VinCodeResponse implements Serializable {

    private static final long serialVersionUID = -3944914280658264818L;

    private String id;
    private LocalDateTime createdDate;
    private String code;
}
