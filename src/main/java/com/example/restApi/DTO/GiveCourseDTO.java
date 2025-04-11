package com.example.restApi.DTO;

public class GiveCourseDTO {
    private Long id;
    private String description;
    private String major;
    private String university;
    private String requirement;
    private String coursecode;
    private double minscore;

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public double getMinscore() {
        return minscore;
    }

    public void setMinscore(double minscore) {
        this.minscore = minscore;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "GiveCourseDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", major='" + major + '\'' +
                ", university='" + university + '\'' +
                ", requirement='" + requirement + '\'' +
                '}';
    }
}
