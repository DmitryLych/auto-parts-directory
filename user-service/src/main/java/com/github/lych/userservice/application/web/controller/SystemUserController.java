package com.github.lych.userservice.application.web.controller;

import com.github.lych.userservice.application.web.dto.request.SystemUserRequest;
import com.github.lych.userservice.application.web.dto.response.SystemUserResponse;
import com.github.lych.userservice.domain.model.SystemUser;
import com.github.lych.userservice.domain.service.SystemUserService;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * The type System user controller.
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemUserController {

    private final SystemUserService service;
    private final Mapper mapper;

    /**
     * Create user response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<SystemUserResponse> createUser(@RequestBody @Valid final SystemUserRequest request) {
        final SystemUser createdUser = service.create(mapper.map(request, SystemUser.class));
        return ResponseEntity.ok(mapper.map(createdUser, SystemUserResponse.class));
    }

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return the user
     */
    @GetMapping("/{userId}")
    public ResponseEntity<SystemUserResponse> getUser(@PathVariable final String userId) {
        final SystemUser foundUser = service.get(userId);
        return ResponseEntity.ok(mapper.map(foundUser, SystemUserResponse.class));
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping
    public ResponseEntity<List<SystemUserResponse>> getUsers() {
        final List<SystemUserResponse> response = service.getAll().stream()
                .filter(Objects::nonNull)
                .map(user -> mapper.map(user, SystemUserResponse.class))
                .collect(toList());

        return ResponseEntity.ok(response);
    }

    /**
     * Update user response entity.
     *
     * @param request the request
     * @param userId  the user id
     * @return the response entity
     */
    @PutMapping("/{userId}")
    public ResponseEntity<SystemUserResponse> updateUser(@RequestBody @Valid final SystemUserRequest request,
                                                         @PathVariable final String userId) {
        final SystemUser userForUpdate = mapper.map(request, SystemUser.class);
        userForUpdate.setId(userId);

        final SystemUser updatedUser = service.update(userForUpdate);
        return ResponseEntity.ok(mapper.map(updatedUser, SystemUserResponse.class));
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable final String userId) {
        service.delete(userId);
    }
}
