package com.example.restApi.Sevices;

import com.example.restApi.DTO.AddCourseDTO;
import com.example.restApi.DTO.GiveCourseDTO;
import com.example.restApi.Repository.CommentByUserRepository;
import com.example.restApi.Repository.CourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.CommentByUser;
import com.example.restApi.model.Course;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private UserRepository userRepository;
    private UniversityRepository universityRepository;
    private CourseRepository courseRepository;
    private CommentByUserRepository commentByUserRepository;
    @Autowired
    public void setCommentByUserRepository(CommentByUserRepository commentByUserRepository) {
        this.commentByUserRepository = commentByUserRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setСourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    public void addCourse(Principal principal, AddCourseDTO addCourseDTO){
        University university = universityRepository.findByUniversity(addCourseDTO.getUniversity()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        User user = userRepository.findByName(principal.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        Course course = new Course();
        course.setDescription(addCourseDTO.getDescription());
        course.setIduniversity(university.getId());
        course.setMajor(addCourseDTO.getMajor());
        course.setIduser(user.getId());
        course.setRequirement(addCourseDTO.getRequirement());
        course.setCoursecode(addCourseDTO.getCoursecode());
        course.setMinscore(addCourseDTO.getMinscore());
        courseRepository.save(course);
    }
    public GiveCourseDTO courseDTOConverter(Course course){
        GiveCourseDTO giveCourseDTO = new GiveCourseDTO();
        giveCourseDTO.setDescription(course.getDescription());
        giveCourseDTO.setMajor(course.getMajor());
        giveCourseDTO.setRequirement(course.getRequirement());
        University university = universityRepository.findById(course.getIduniversity()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        giveCourseDTO.setUniversity(university.getUniversity());
        giveCourseDTO.setId(course.getId());
        giveCourseDTO.setCoursecode(course.getCoursecode());
        giveCourseDTO.setMinscore(course.getMinscore());
        return giveCourseDTO;
    }
    public List<GiveCourseDTO> courseDTOListConverter(List<Course> courseList){
        List<GiveCourseDTO> courseDTOList = new ArrayList<>();
        for(Course course : courseList){
            courseDTOList.add(courseDTOConverter(course));
        }
        return courseDTOList;

    }
    public List<GiveCourseDTO> allCourse(){
        return courseDTOListConverter(courseRepository.findAll());
    }
    public List<GiveCourseDTO> getAllCourse(Principal principal){
        User user = userRepository.findByName(principal.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        List<Course> coursesList = courseRepository.findByIduser(user.getId());
        return courseDTOListConverter(coursesList);
    }
    public GiveCourseDTO giveCourseById(Long id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        return courseDTOConverter(course);
    }


    public List<GiveCourseDTO> giveCourseByIdUser(Long id) {
        return courseDTOListConverter(courseRepository.findByIduser(id));

    }
    public String deleteCourse(Long id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        List<CommentByUser> commentListByCourseId = commentByUserRepository.findByIdcourse(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        commentByUserRepository.deleteAll(commentListByCourseId);
        courseRepository.delete(course);
        return "OK";
    }
}
