package com.github.lych.user.service.domain.service;

import com.github.lych.user.service.domain.model.SystemUser;

import java.util.List;

/**
 * Service for {@link SystemUser}.
 */
public interface SystemUserService {

    /**
     * Create new {@link SystemUser}.
     *
     * @param user a {@link SystemUser} for creation
     * @return created {@link SystemUser}
     */
    SystemUser create(SystemUser user);

    /**
     * Get the {@link SystemUser} by identifier.
     *
     * @param id a identifier
     * @return the {@link SystemUser}
     */
    SystemUser get(String id);

    /**
     * Get all {@link SystemUser}.
     *
     * @return list of {@link SystemUser}
     */
    List<SystemUser> getAll();

    /**
     * Update the {@link SystemUser}.
     *
     * @param user a {@link SystemUser} for update
     * @return the {@link SystemUser}
     */
    SystemUser update(SystemUser user);

    /**
     * Delete the {@link SystemUser} by identifier.
     *
     * @param id a identifier
     */
    void delete(String id);
}
