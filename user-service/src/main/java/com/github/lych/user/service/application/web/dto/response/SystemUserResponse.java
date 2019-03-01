package com.github.lych.user.service.application.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * System user response DTO.
 */
@Getter
@Setter
public class SystemUserResponse implements Serializable {

    private static final long serialVersionUID = -3842382956512403964L;

    private String id;
    private LocalDateTime createdDate;
    private String forename;
    private String surname;
    private String email;
    private String mobilePhone;
}
