package com.github.lych.parts.directory.service.application.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * The type Vin code request.
 */
@Getter
@Setter
public class VinCodeRequest implements Serializable {

    private static final long serialVersionUID = -5892403008718305515L;

    @NotBlank
    private String code;
}
