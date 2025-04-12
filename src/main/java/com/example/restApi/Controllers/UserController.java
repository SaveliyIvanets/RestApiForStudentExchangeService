package com.example.restApi.Controllers;

import com.example.restApi.DTO.GiveUserDTO;
import com.example.restApi.Sevices.UserService;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;


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
    @GetMapping("/getByString")
    public List<GiveUserDTO> getByString(@RequestParam String user){
        return userService.getByString(user);
    }
}
