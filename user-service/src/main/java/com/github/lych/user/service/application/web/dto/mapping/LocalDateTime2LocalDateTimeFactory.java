package com.github.lych.user.service.application.web.dto.mapping;

import org.dozer.BeanFactory;

import java.time.LocalDateTime;

/**
 * Factory for init {@link LocalDateTime}.
 */
public class LocalDateTime2LocalDateTimeFactory implements BeanFactory {

    @Override
    public Object createBean(final Object source, final Class<?> sourceClass, final String targetBeanId) {
        if (source == null || sourceClass == null || !sourceClass.isAssignableFrom(LocalDateTime.class)) {
            return null;
        }

        final LocalDateTime timeFromSource = (LocalDateTime) source;
        return LocalDateTime.of(timeFromSource.getYear(), timeFromSource.getMonth(), timeFromSource.getDayOfMonth(),
                timeFromSource.getHour(), timeFromSource.getMinute(),
                timeFromSource.getSecond(), timeFromSource.getNano());
    }
}
