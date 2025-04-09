package com.example.restApi.Repository;

import com.example.restApi.model.UserAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAvatarRepository extends JpaRepository<UserAvatar,Long> {
}
