package com.example.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "commentbyuser")
public class CommentByUser {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String comment;
    @Column
    private Long idanswerto;
    @Column
    private Long iduser;
    @Column
    private Long idcourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getIdanswerto() {
        return idanswerto;
    }

    public void setIdanswerto(Long idanswerto) {
        this.idanswerto = idanswerto;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Long getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Long idcourse) {
        this.idcourse = idcourse;
    }
}
