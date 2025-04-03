package com.jaisriram.todorestapi;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // reduces boiler plate for getters and setters
@NoArgsConstructor // reduces boiler plate for no args constructor
@AllArgsConstructor // reduces boiler plate for all args constructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private LocalDate targetDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean done;
}
