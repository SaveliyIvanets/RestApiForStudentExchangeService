package com.example.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personprogramcourse")
public class personprogramcourse {
    @Id
    private Long id_person;

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }

    public Long getId_program() {
        return id_program;
    }

    public void setId_program(Long id_program) {
        this.id_program = id_program;
    }

    @Id
    private Long id_program;

}
