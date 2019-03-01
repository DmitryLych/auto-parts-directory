package com.github.lych.userservice.application.web.dto.request;

import com.github.lych.userservice.application.validation.annotation.CorrectEmailFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * System user request DTO.
 */
@Getter
@Setter
public class SystemUserRequest implements Serializable {

    private static final long serialVersionUID = -4844040752967212859L;

    @NotBlank
    private String forename;
    @NotBlank
    private String surname;
    @CorrectEmailFormat
    private String email;
    private String mobilePhone;
}
