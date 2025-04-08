package com.example.restApi.Controllers;

import com.example.restApi.DTO.GiveUserDTO;
import com.example.restApi.Sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllAboutUser")
    public GiveUserDTO getAllAboutUser(Principal principal){
        return userService.getAllAboutUser(principal);
    }
    @GetMapping("/{id}")
    public GiveUserDTO getAllAboutUserById(@PathVariable Long id){
        return userService.getAllAboutUserByID(id);
    }


}
