package com.example.restApi.Repository;

import com.example.restApi.model.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhotoRepository extends JpaRepository<UserPhoto,Long> {
}
