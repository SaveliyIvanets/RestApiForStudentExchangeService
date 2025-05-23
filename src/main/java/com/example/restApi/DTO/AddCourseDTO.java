package com.example.restApi.DTO;

public class AddCourseDTO {
    private String university;
    private String description;
    private String major;
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}
