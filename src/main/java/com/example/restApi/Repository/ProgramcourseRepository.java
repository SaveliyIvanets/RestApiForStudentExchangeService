package com.example.restApi.Repository;

import com.example.restApi.model.ProgramCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramcourseRepository extends JpaRepository<ProgramCourse,Long> {

}
