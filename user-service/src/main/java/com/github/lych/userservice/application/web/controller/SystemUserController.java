package com.github.lych.userservice.application.web.controller;

import com.github.lych.userservice.domain.model.SystemUser;
import com.github.lych.userservice.domain.service.SystemUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemUserController {

    private final SystemUserService service;

    @GetMapping("/{userId}")
    public ResponseEntity<SystemUser> getUser(@PathVariable final String userId) {
        return ResponseEntity.ok().body(service.get(userId));
    }
}
