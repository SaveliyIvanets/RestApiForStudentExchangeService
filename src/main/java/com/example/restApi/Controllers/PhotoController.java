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

    @PostMapping("setAvatar/{id}")
    public String uploadPhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
         return photoService.uploadPhoto(id,file);
     }
     @GetMapping("/{id}")
     public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) {
        return photoService.getPhoto(id);
     }
}
