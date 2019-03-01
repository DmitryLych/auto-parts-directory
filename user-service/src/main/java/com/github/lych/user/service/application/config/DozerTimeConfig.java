package com.github.lych.user.service.application.config;

import com.github.lych.user.service.application.web.dto.mapping.LocalDateTime2LocalDateTimeFactory;
import org.dozer.loader.api.BeanMappingBuilder;

import java.time.LocalDateTime;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

/**
 * Dozer config for work with time.
 */
public class DozerTimeConfig extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(LocalDateTime.class, type(LocalDateTime.class).beanFactory(LocalDateTime2LocalDateTimeFactory.class),
                oneWay());
    }
}
