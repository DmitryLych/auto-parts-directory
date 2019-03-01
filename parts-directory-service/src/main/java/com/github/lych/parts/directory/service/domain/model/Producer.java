package com.github.lych.parts.directory.service.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Producer entity.
 */
@Getter
@Setter
@Entity
@Table(name = "producer")
public class Producer extends AbstractEntity {

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String email;
}
