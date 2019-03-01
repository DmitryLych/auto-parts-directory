package com.github.lych.parts.directory.service.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Car entity.
 */
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends AbstractEntity {

    @Column
    private String make;
    @Column
    private String model;
    @Column
    private LocalDate startProduction;
    @Column
    private LocalDate endProduction;

    @ManyToOne
    private Producer producer;
}
