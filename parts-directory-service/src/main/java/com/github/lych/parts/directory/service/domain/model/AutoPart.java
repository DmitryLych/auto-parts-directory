package com.github.lych.parts.directory.service.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.EnumType.STRING;

/**
 * Auto part entity.
 */
@Getter
@Setter
@Entity
@Table(name = "auto_part")
public class AutoPart extends AbstractEntity {

    @Column
    private Double coast;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @Enumerated(value = STRING)
    private AutoPartType type;

    @ManyToOne
    private Producer producer;
    @ManyToMany
    private List<Car> cars;
}
