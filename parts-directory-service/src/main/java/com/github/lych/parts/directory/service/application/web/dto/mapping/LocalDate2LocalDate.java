package com.github.lych.parts.directory.service.application.web.dto.mapping;

import org.dozer.BeanFactory;

import java.time.LocalDate;

/**
 * The type Local date 2 local date.
 */
public class LocalDate2LocalDate implements BeanFactory {

    @Override
    public Object createBean(final Object source, final Class<?> sourceClass, final String targetBeanId) {
        if (source == null || sourceClass == null || !sourceClass.isAssignableFrom(LocalDate.class)) {
            return null;
        }

        final LocalDate dateFromSource = (LocalDate) source;
        return LocalDate.of(dateFromSource.getYear(), dateFromSource.getMonth(), dateFromSource.getDayOfMonth());
    }
}
