package com.example.restApi.Repository;

import com.example.restApi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByIduser(Long idUser);
    List<Course> findByIduniversity(Long idUni);


}
