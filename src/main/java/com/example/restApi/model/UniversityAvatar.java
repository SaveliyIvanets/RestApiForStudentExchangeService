package com.example.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "universityavatar")
public class UniversityAvatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String avatar;
    @Column
    private String avatarmimetype;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmimetype() {
        return avatarmimetype;
    }

    public void setAvatarmimetype(String avatarmimetype) {
        this.avatarmimetype = avatarmimetype;
    }

}
