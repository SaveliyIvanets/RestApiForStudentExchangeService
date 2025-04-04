package com.example.restApi.Controllers;

import com.example.restApi.Repository.ProgramcourseRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.ProgramCourse;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;
    private ProgramcourseRepository programcourseRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setProgramcourseRepository(ProgramcourseRepository programcourseRepository) {
        this.programcourseRepository = programcourseRepository;
    }

}
