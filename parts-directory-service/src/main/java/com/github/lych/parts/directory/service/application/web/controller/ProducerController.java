package com.github.lych.parts.directory.service.application.web.controller;

import com.github.lych.parts.directory.service.domain.model.VinCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vin-codes")
public class ProducerController {

    @PostMapping
    public void create(@RequestBody final VinCode vinCode) {
        System.out.println(vinCode);
    }
}
