package com.grabduck.demo.springsecurity.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Instant expiration;

    @OneToOne
    @MapsId
    private User user;
}
