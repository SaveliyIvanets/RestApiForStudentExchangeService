package com.example.restApi.Controllers;

import com.example.restApi.DTO.AddCourseDTO;
import com.example.restApi.DTO.GiveCourseDTO;
import com.example.restApi.Repository.CourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.Sevices.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {


    private CourseService courseService;
    private UserRepository userRepository;
    private UniversityRepository universityRepository;
    private CourseRepository courseRepository;
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProgramcourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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
