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
   /* @PostMapping("/{Id}/avatar")
    public String uploadPhoto(@PathVariable Long Id, @RequestParam("file") MultipartFile file) throws IOException {
        return userService.uploadPhoto(Id,file);
    }*/
   /* @GetMapping("/getAvatar/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) {
        Photo photo = photoService.getPhotoById(id);

        // Декодируем Base64 обратно в byte[]
        byte[] imageBytes = Base64.getDecoder().decode(photo.getImageBase64());

        // Возвращаем с правильным MIME-типом
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.getMimeType()))
                .body(imageBytes);
    }
}*/



}
