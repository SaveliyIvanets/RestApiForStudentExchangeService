package com.example.restApi.DTO;

import java.util.List;

public class GiveUniDTO {
    private Long id;
    private String university;
    private List<GiveCourseDTO> giveCourseDTOList;
    private List<GiveUserDTO> mentorList;
    private GiveUserDTO creator;

    public GiveUserDTO getCreator() {
        return creator;
    }

    public void setCreator(GiveUserDTO creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GiveUserDTO> getMentorList() {
        return mentorList;
    }

    public void setMentorList(List<GiveUserDTO> mentorList) {
        this.mentorList = mentorList;
    }



    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public List<GiveCourseDTO> getGiveCourseDTOList() {
        return giveCourseDTOList;
    }

    public void setGiveCourseDTOList(List<GiveCourseDTO> giveCourseDTOList) {
        this.giveCourseDTOList = giveCourseDTOList;
    }
}
