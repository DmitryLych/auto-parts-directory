package com.github.lych.parts.directory.service.application.web.dto.response;

import com.github.lych.parts.directory.service.domain.model.AutoPartType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Auto part response.
 */
@Getter
@Setter
public class AutoPartResponse implements Serializable {

    private static final long serialVersionUID = 8067516072780748960L;

    private String id;
    private LocalDateTime createdDate;
    private Double coast;
    private String name;
    private String description;
    private AutoPartType type;
}
