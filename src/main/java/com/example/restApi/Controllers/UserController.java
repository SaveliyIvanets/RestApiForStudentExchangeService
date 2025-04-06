package com.example.restApi.Controllers;

import com.example.restApi.DTO.GiveUserDTO;
import com.example.restApi.Repository.ProgramcourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/user")
public class UserController {
    private UniversityRepository universityRepository;
    private UserRepository userRepository;
    private ProgramcourseRepository programcourseRepository;
    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setProgramcourseRepository(ProgramcourseRepository programcourseRepository) {
        this.programcourseRepository = programcourseRepository;
    }
    @GetMapping("/getAllAboutUser")
    public GiveUserDTO getAllAbout(Principal principal){
        User user = userRepository.findByName(principal.getName()).orElseThrow(() -> new BadCredentialsException("User not found"));
        University university = universityRepository.findById(user.getIduniversity()).orElseThrow(() -> new BadCredentialsException("University not found"));
        GiveUserDTO giveUserDto  = new GiveUserDTO();
        giveUserDto.setEmail(user.getEmail());
        giveUserDto.setFullname(user.getFullname());
        giveUserDto.setRole(user.getRole());
        giveUserDto.setUniversity(university.getUniversity());
        return giveUserDto;
    }


}
