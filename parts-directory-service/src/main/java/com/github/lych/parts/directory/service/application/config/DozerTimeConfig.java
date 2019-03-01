package com.github.lych.parts.directory.service.application.config;

import com.github.lych.parts.directory.service.application.web.dto.mapping.LocalDate2LocalDate;
import com.github.lych.parts.directory.service.application.web.dto.mapping.LocalDateTime2LocalDateTime;
import org.dozer.loader.api.BeanMappingBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DozerTimeConfig extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(LocalDate.class, type(LocalDate.class).beanFactory(LocalDate2LocalDate.class), oneWay());
        mapping(LocalDateTime.class, type(LocalDateTime.class).beanFactory(LocalDateTime2LocalDateTime.class),
                oneWay());
    }
}
