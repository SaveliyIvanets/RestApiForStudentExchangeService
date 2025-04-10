package com.example.restApi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String university;
    @Column
    private Long iduniversityavatar;
    @Column
    private Long iduniversityheader;

    public Long getIduniversityavatar() {
        return iduniversityavatar;
    }

    public void setIduniversityavatar(Long iduniversityavatar) {
        this.iduniversityavatar = iduniversityavatar;
    }

    public Long getIduniversityheader() {
        return iduniversityheader;
    }

    public void setIduniversityheader(Long iduniversityheader) {
        this.iduniversityheader = iduniversityheader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
