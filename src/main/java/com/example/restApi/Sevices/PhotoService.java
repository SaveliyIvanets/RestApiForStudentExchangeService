package com.example.restApi.Sevices;

import com.example.restApi.Repository.*;
import com.example.restApi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;

@Service
public class PhotoService {
    private UniversityHeaderRepository universityHeaderRepository;
    private UserRepository userRepository;
    private UserPhotoRepository userPhotoRepository;
    private UniversityRepository universityRepository;
    private UniversityAvatarRepository universityAvatarRepository;
    @Autowired

    public void setUniversityHeaderRepository(UniversityHeaderRepository universityHeaderRepository) {
        this.universityHeaderRepository = universityHeaderRepository;
    }

    @Autowired
    public void setUniversityAvatarRepository(UniversityAvatarRepository universityAvatarRepository) {
        this.universityAvatarRepository = universityAvatarRepository;
    }

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Autowired
    public void setUserPhotoRepository(UserPhotoRepository userPhotoRepository) {
        this.userPhotoRepository = userPhotoRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public String uploadPhotoUser(Long Id, MultipartFile file) throws IOException {
        User user = userRepository.findById(Id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setAvatar(Base64.getEncoder().encodeToString(file.getBytes()));
        userPhoto.setMimetype(file.getContentType());
        userPhotoRepository.save(userPhoto);
        user.setIduseravatar(userPhoto.getId());
        userRepository.save(user);
        return "Фото успешно загружено для пользователя ID: " + Id;
    }
    public ResponseEntity<byte[]> getPhotoUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UserPhoto userPhoto = userPhotoRepository.findById(user.getIduseravatar()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        byte[] imageBytes = Base64.getDecoder().decode(userPhoto.getAvatar());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(userPhoto.getMimetype()))
                .body(imageBytes);
    }
    public String uploadPhotoUniversity(Long Id, MultipartFile file) throws IOException {
        University university = universityRepository.findById(Id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UniversityAvatar universityAvatar = new UniversityAvatar();
        universityAvatar.setAvatar(Base64.getEncoder().encodeToString(file.getBytes()));
        universityAvatar.setAvatarmimetype(file.getContentType());
        universityAvatarRepository.save(universityAvatar);
        university.setIduniversityavatar(universityAvatar.getId());
        universityRepository.save(university);
        return "Фото успешно загружено для университета ID: " + Id;
    }
    public ResponseEntity<byte[]> getPhotoUniversity(Long id) {
        University university = universityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UniversityAvatar universityAvatar = universityAvatarRepository.findById(university.getIduniversityavatar()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        byte[] imageBytes = Base64.getDecoder().decode(universityAvatar.getAvatar());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(universityAvatar.getAvatarmimetype()))
                .body(imageBytes);
    }
    public String uploadHeaderUniversity(Long Id, MultipartFile file) throws IOException {
        University university = universityRepository.findById(Id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UniversityHeader universityHeader = new UniversityHeader();
        universityHeader.setHeader(Base64.getEncoder().encodeToString(file.getBytes()));
        universityHeader.setHeadermimetype(file.getContentType());
        universityHeaderRepository.save(universityHeader);
        university.setIduniversityheader(universityHeader.getId());
        universityRepository.save(university);
        return "Фото успешно загружено для университета ID: " + Id;
    }
    public ResponseEntity<byte[]> getHeaderUniversity(Long id) {
        University university = universityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        UniversityHeader universityHeader = universityHeaderRepository.findById(university.getIduniversityheader()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        byte[] imageBytes = Base64.getDecoder().decode(universityHeader.getHeader());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(universityHeader.getHeadermimetype()))
                .body(imageBytes);
    }
}
