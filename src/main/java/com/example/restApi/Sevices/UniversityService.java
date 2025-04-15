package com.example.restApi.Sevices;

import com.example.restApi.DTO.GiveCourseDTO;
import com.example.restApi.DTO.GiveUniDTO;
import com.example.restApi.DTO.GiveUserDTO;
import com.example.restApi.Repository.CourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.Course;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    private UserService userService;
    private CourseService courseService;
    private UniversityRepository universityRepository;
    private CourseRepository courseRepository;
    private UserRepository userRepository;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public GiveUniDTO getAllAboutUniById(Long id){
        University university = universityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        return uniDTOConverter(university);
    }
    public List<GiveUniDTO> getAll(){
        List<University> universityList = universityRepository.findAll();
        return uniListDTOConverter(universityList);
    }
    public GiveUniDTO uniDTOConverter(University university) {
        GiveUniDTO giveUniDTO = new GiveUniDTO();
        List<User> mentorList = userRepository.findByRoleAndIduniversity("mentor",university.getId());
        List<User> creatorList = userRepository.findByRoleAndIduniversity("creator",university.getId());
        if(!creatorList.isEmpty()){
            giveUniDTO.setCreator(userService.userDTOConverter(creatorList.getFirst()));
        }
        List<Course> courseList = courseRepository.findByIduniversity(university.getId());
        giveUniDTO.setUniversity(university.getUniversity());
        giveUniDTO.setGiveCourseDTOList(courseService.courseDTOListConverter(courseList));
        giveUniDTO.setMentorList(userService.userListDTOConverter(mentorList));
        giveUniDTO.setId(university.getId());

        return giveUniDTO;
    }

    public List<GiveUniDTO> uniListDTOConverter(List<University> uniList) {
        List<GiveUniDTO> giveUniDTOList = new ArrayList<>();
        for (University university : uniList) {
            giveUniDTOList.add(uniDTOConverter(university));
        }
        return giveUniDTOList;

    }
}
