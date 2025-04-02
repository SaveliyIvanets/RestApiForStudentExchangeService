package com.example.restApi.Controllers;

import com.example.restApi.DTO.addCourseDto;
import com.example.restApi.Repository.PersonprogramcourseRepository;
import com.example.restApi.Repository.ProgramcourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.Personprogramcourse;
import com.example.restApi.model.ProgramCourse;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
public class CourseController {
    private UserRepository userRepository;
    private UniversityRepository universityRepository;
    private ProgramcourseRepository programcourseRepository;
    private PersonprogramcourseRepository personprogramcourseRepository;
    @Autowired
    public void setPersonprogramcourseRepository(PersonprogramcourseRepository personprogramcourseRepository) {
        this.personprogramcourseRepository = personprogramcourseRepository;
    }

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

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(Principal principal,@RequestBody addCourseDto addCourseDto) {
        University university = universityRepository.findByUniversity(addCourseDto.getUniversity()).orElseThrow(() -> new BadCredentialsException("University not found"));

        ProgramCourse programCourse = new ProgramCourse();
        programCourse.setDescription(addCourseDto.getDescription());
        programCourse.setIduniversity(university.getId());
        programCourse.setMajor(addCourseDto.getMajor());
        System.out.println(programCourse);

        programcourseRepository.save(programCourse);

        Personprogramcourse personprogramcourse = new Personprogramcourse();
        User user = userRepository.findByName(principal.getName())
                .orElseThrow(() -> new BadCredentialsException("User not found"));
        personprogramcourse.setId_person(user.getId());
        personprogramcourse.setId_program(programCourse.getId());
        personprogramcourseRepository.save(personprogramcourse);

        return ResponseEntity.ok("Done!");
    }
    @GetMapping("/name")
    public String name(Principal principal){
        return principal.getName();
    }
}
