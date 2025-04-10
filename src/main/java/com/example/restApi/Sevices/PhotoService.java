package com.example.restApi.Sevices;

import com.example.restApi.Repository.UserAvatarRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.User;
import com.example.restApi.model.UserAvatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;

@Service
public class PhotoService {
    private UserRepository userRepository;
    private UserAvatarRepository userAvatarRepository;
    @Autowired
    public void setUserAvatarRepository(UserAvatarRepository userAvatarRepository) {
        this.userAvatarRepository = userAvatarRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String uploadPhoto(Long Id, MultipartFile file) throws IOException {
        User user = userRepository.findById(Id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setAvatar(Base64.getEncoder().encodeToString(file.getBytes()));
        userAvatar.setMimetype(file.getContentType());
        userAvatarRepository.save(userAvatar);
        user.setIduseravatar(userAvatar.getId());
        userRepository.save(user);
        return "Фото успешно загружено для пользователя ID: " + Id;
    }
    public ResponseEntity<byte[]> getPhoto(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        System.out.println(user.getIduseravatar());
        UserAvatar userAvatar = userAvatarRepository.findById(user.getIduseravatar()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        byte[] imageBytes = Base64.getDecoder().decode(userAvatar.getAvatar());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(userAvatar.getMimetype()))
                .body(imageBytes);
    }
}
