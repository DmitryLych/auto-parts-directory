package com.github.lych.parts.directory.service.application.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * The type Producer request.
 */
@Getter
@Setter
public class ProducerRequest implements Serializable {

    private static final long serialVersionUID = -7718111292897884366L;

    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String email;
}
