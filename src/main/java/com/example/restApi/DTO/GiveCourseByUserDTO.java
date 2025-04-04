package com.example.restApi.DTO;

public class GiveCourseByUserDTO {
    private Long id;
    private String description;
    private String major;
    private Long university;
    private String requirement;

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

    public Long getUniversity() {
        return university;
    }

    public void setUniversity(Long university) {
        this.university = university;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
