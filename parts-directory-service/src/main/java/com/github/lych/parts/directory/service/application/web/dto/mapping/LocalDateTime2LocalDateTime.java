package com.github.lych.parts.directory.service.application.web.dto.mapping;

import org.dozer.BeanFactory;

import java.time.LocalDateTime;

/**
 * The type Local date time 2 local date time.
 */
public class LocalDateTime2LocalDateTime implements BeanFactory {

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
