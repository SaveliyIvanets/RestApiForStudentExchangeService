package com.example.restApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "programcourse")
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private String major;
    @Column
    private Long iduniversity;
    @Column
    private Long iduser;
    @Column(columnDefinition = "TEXT")
    private String requirement;
    @Column
    private double minscore;
    @Column
    private String coursecode;

    public double getMinscore() {
        return minscore;
    }

    public void setMinscore(double minscore) {
        this.minscore = minscore;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getIduniversity() {
        return iduniversity;
    }

    public void setIduniversity(Long idunivercity) {
        this.iduniversity = idunivercity;
    }


}
