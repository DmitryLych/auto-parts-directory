package com.github.lych.parts.directory.service.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vin code entity.
 */
@Getter
@Setter
@Entity
@Table(name = "vin_code")
public class VinCode extends AbstractEntity {

    @Column(unique = true, nullable = false, updatable = false)
    private String code;

    @ManyToOne
    private Car car;
}
