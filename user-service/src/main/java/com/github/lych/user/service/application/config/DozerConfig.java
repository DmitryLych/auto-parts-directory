package com.github.lych.user.service.application.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config for {@link DozerBeanMapper}
 */
@Configuration
public class DozerConfig {

    /**
     * Init {@link DozerBeanMapper}.
     *
     * @return the {@link DozerBeanMapper}
     */
    @Bean
    public DozerBeanMapper mapper() {
        final DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new DozerTimeConfig());

        return mapper;
    }
}
