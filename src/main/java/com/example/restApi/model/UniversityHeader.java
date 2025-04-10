package com.example.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "universityheader")
public class UniversityHeader {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String header;
    @Column
    private String headermimetype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeadermimetype() {
        return headermimetype;
    }

    public void setHeadermimetype(String headermimetype) {
        this.headermimetype = headermimetype;
    }
}
