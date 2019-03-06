package com.github.lych.parts.directory.service.application.web.dto.request;

import com.github.lych.parts.directory.service.domain.model.AutoPartType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * The type Auto part request.
 */
@Getter
@Setter
public class AutoPartRequest implements Serializable {

    private static final long serialVersionUID = 3550146998463917429L;

    @NotNull
    private Double coast;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private AutoPartType type;

    @NotEmpty
    private List<String> carsId;
}
