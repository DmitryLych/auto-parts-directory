package com.github.lych.parts.directory.service.application.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class CarRequest implements Serializable {

    private static final long serialVersionUID = 7459931840950582134L;

    @NotBlank
    private String make;
    @NotBlank
    private String model;
    @NotNull
    private LocalDate startProduction;
    private LocalDate endProduction;
}
