package com.github.lych.user.service.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * System user entity.
 */
@Getter
@Setter
@Entity
@Table(name = "system_user")
public class SystemUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column
    private String forename;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String mobilePhone;
}
