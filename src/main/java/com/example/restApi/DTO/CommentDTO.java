package com.example.restApi.DTO;

public class CommentDTO {
    private String comment;
    private Long idcourse;
    private Long iduser;
    private Long idanswerto;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
