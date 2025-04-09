package com.example.restApi.Controllers;

import com.example.restApi.DTO.GiveUserDTO;
import com.example.restApi.Sevices.UserService;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping("/{Id}/photo")
    public String uploadPhoto(@PathVariable Long Id, @RequestParam("file") MultipartFile file) throws IOException {
        return userService.uploadPhoto(Id,file);

    }



}
