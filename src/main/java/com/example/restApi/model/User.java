package com.example.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String role;
    @Column
    private Long iduniversity;
    @Column
    private String fullname;
    @Column
    private Long iduseravatar;

    public Long getIduseravatar() {
        return iduseravatar;
    }

    public void setIduseravatar(Long iduseravatar) {
        this.iduseravatar = iduseravatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getIduniversity() {
        return iduniversity;
    }

    public void setIduniversity(Long iduniversity) {
        this.iduniversity = iduniversity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
