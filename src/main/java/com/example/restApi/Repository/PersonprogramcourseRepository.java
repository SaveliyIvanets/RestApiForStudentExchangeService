package com.example.restApi.Repository;

import com.example.restApi.model.Personprogramcourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonprogramcourseRepository extends JpaRepository<Personprogramcourse,Long> {
}
