package com.example.restApi.DTO;

import java.util.List;

public class GiveUniDTO {
    private String university;
    private List<GiveCourseDTO> giveCourseDTOList;
    private List<GiveUserDTO> giveUserDTOList;

    public List<GiveUserDTO> getGiveUserDTOList() {
        return giveUserDTOList;
    }

    public void setGiveUserDTOList(List<GiveUserDTO> giveUserDTOList) {
        this.giveUserDTOList = giveUserDTOList;
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
