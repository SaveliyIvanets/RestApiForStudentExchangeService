package com.example.restApi.Controllers;

import com.example.restApi.DTO.AddCourseDTO;
import com.example.restApi.DTO.GiveCourseDTO;
import com.example.restApi.Repository.ProgramcourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.Sevices.CourseService;
import com.example.restApi.model.ProgramCourse;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {


    private CourseService courseService;
    private UserRepository userRepository;
    private UniversityRepository universityRepository;
    private ProgramcourseRepository programcourseRepository;
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
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
    public ResponseEntity<?> addCourse(Principal principal,@RequestBody AddCourseDTO addCourseDto) {
        courseService.addCourse(principal,addCourseDto);
        return ResponseEntity.ok("Done!");
    }
    @GetMapping("/allCourse")
    public List<GiveCourseDTO> allCourse(){
        return courseService.allCourse();
    }
    @GetMapping("/allCourseByUser")
    public List<GiveCourseDTO> getAllCourse(Principal principal){
        return courseService.getAllCourse(principal);
    }

}
