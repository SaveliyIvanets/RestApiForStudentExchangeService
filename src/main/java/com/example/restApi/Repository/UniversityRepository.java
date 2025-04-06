package com.example.restApi.Repository;

import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
    Optional<University> findByUniversity(String university);
    Optional<University> findById(Long Id);
}
