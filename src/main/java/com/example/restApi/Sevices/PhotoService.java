package com.example.restApi.Sevices;

import com.example.restApi.Repository.UserAvatarRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.User;
import com.example.restApi.model.UserAvatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        User user = userRepository.findById(Id).orElseThrow(() -> new BadCredentialsException("User not found"));
        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setAvatar(Base64.getEncoder().encodeToString(file.getBytes()));
        userAvatar.setMimetype(file.getContentType());
        userAvatarRepository.save(userAvatar);
        user.setIduseravatar(userAvatar.getId());
        userRepository.save(user);
        return "Фото успешно загружено для пользователя ID: " + Id;
    }
}
