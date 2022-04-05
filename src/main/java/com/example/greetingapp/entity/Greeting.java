package com.example.greetingapp.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table
public class Greeting {
    @Id
    @Column(nullable = false)
    private final long id;
    private final String message;
    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {
        id = 0;
        message = "";
    }
}
