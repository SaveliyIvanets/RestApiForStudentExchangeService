package com.example.restApi.Controllers;

import com.example.restApi.Sevices.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("setUserAvatar/{id}")
    public String uploadPhotoUser(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
         return photoService.uploadPhotoUser(id,file);
     }
     @GetMapping("/user/{id}")
     public ResponseEntity<byte[]> getPhotoUser(@PathVariable Long id) {
        return photoService.getPhotoUser(id);
     }
     @PostMapping("/setUniversityAvatar/{id}")
     public String uploadPhotoUniversity(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
         return photoService.uploadPhotoUniversity(id,file);
     }
    @GetMapping("/university/avatar/{id}")
    public ResponseEntity<byte[]> getPhotoUniversity(@PathVariable Long id) {
        return photoService.getPhotoUniversity(id);
    }
    @PostMapping("/setUniversityHeader/{id}")
    public String uploadHeaderUniversity(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        return photoService.uploadHeaderUniversity(id,file);
    }
    @GetMapping("/university/header/{id}")
    public ResponseEntity<byte[]> getHeaderUniversity(@PathVariable Long id) {
        return photoService.getHeaderUniversity(id);
    }

}
