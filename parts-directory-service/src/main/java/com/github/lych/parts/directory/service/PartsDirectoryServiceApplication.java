package com.github.lych.parts.directory.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PartsDirectoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartsDirectoryServiceApplication.class, args);
    }

}
