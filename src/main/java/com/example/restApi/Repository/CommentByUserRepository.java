package com.example.restApi.Repository;

import com.example.restApi.model.CommentByUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentByUserRepository extends JpaRepository<CommentByUser,Long> {
    Optional<List<CommentByUser>> findByIdcourse(Long id);
}
