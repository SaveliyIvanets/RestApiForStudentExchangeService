package com.example.restApi.Sevices;

import com.example.restApi.DTO.AddCourseDTO;
import com.example.restApi.DTO.GiveCourseDTO;
import com.example.restApi.Repository.ProgramcourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.ProgramCourse;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private UserRepository userRepository;
    private UniversityRepository universityRepository;
    private ProgramcourseRepository programcourseRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProgramcourseRepository(ProgramcourseRepository programcourseRepository) {
        this.programcourseRepository = programcourseRepository;
    }


    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    public void addCourse(Principal principal, AddCourseDTO addCourseDTO){
        University university = universityRepository.findByUniversity(addCourseDTO.getUniversity()).orElseThrow(() -> new BadCredentialsException("University not found"));
        User user = userRepository.findByName(principal.getName())
                .orElseThrow(() -> new BadCredentialsException("User not found"));

        ProgramCourse programCourse = new ProgramCourse();
        programCourse.setDescription(addCourseDTO.getDescription());
        programCourse.setIduniversity(university.getId());
        programCourse.setMajor(addCourseDTO.getMajor());
        programCourse.setIduser(user.getId());
        programCourse.setRequirement(addCourseDTO.getRequirement());

        programcourseRepository.save(programCourse);
    }
    public GiveCourseDTO courseDTOConverter(ProgramCourse programCourse){
        GiveCourseDTO giveCourseDTO = new GiveCourseDTO();
        giveCourseDTO.setDescription(programCourse.getDescription());
        giveCourseDTO.setMajor(programCourse.getMajor());
        giveCourseDTO.setRequirement(programCourse.getRequirement());
        University university = universityRepository.findById(programCourse.getIduniversity()).orElseThrow(() -> new BadCredentialsException("University not found"));
        giveCourseDTO.setUniversity(university.getUniversity());
        giveCourseDTO.setId(programCourse.getId());
        return giveCourseDTO;
    }
    public List<GiveCourseDTO> courseDTOListConverter(List<ProgramCourse> programCourseList){
        List<GiveCourseDTO> courseDTOList = new ArrayList<>();
        for(ProgramCourse programCourse : programCourseList){
            courseDTOList.add(courseDTOConverter(programCourse));
        }
        return courseDTOList;

    }
    public List<GiveCourseDTO> allCourse(){
        return courseDTOListConverter(programcourseRepository.findAll());
    }
    public List<GiveCourseDTO> getAllCourse(Principal principal){
        User user = userRepository.findByName(principal.getName()).orElseThrow(() -> new BadCredentialsException("User not found"));
        List<ProgramCourse> programCoursesList = programcourseRepository.findByIduser(user.getId());
        return courseDTOListConverter(programCoursesList);
    }





}
