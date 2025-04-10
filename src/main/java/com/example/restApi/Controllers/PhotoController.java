package com.example.restApi.Controllers;

import com.example.restApi.Sevices.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    PhotoService photoService =new PhotoService();
    @Autowired
    public void setPhotoService(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("setAvatar/{Id}")
    public String uploadPhoto(@PathVariable Long Id, @RequestParam("file") MultipartFile file) throws IOException {
         return photoService.uploadPhoto(Id,file);
     }
}
