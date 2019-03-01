package com.github.lych.parts.directory.service.application.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dozer configuration.
 */
@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper mapper() {
        final DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new DozerTimeConfig());

        return mapper;
    }
}
