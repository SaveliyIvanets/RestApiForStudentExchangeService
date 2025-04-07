package com.example.restApi.Sevices;

import com.example.restApi.DTO.GiveUserDTO;
import com.example.restApi.JwtTokenSecuritySettings.UserDetailsImpl;
import com.example.restApi.Repository.ProgramcourseRepository;
import com.example.restApi.Repository.UniversityRepository;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.University;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService implements UserDetailsService {
    private UniversityRepository universityRepository;
    private UserRepository userRepository;



    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUsersByName(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new AuthenticationServiceException("Empty password for user: " + username);
        }

        return UserDetailsImpl.build(user);
    }

    public GiveUserDTO userDTOConverter(User user, University university){
        GiveUserDTO giveUserDto = new GiveUserDTO();
        giveUserDto.setEmail(user.getEmail());
        giveUserDto.setFullname(user.getFullname());
        giveUserDto.setRole(user.getRole());
        giveUserDto.setUniversity(university.getUniversity());
        return giveUserDto;
    }
    public GiveUserDTO getAllAboutUser(Principal principal){
        User user = userRepository.findByName(principal.getName()).orElseThrow(() -> new BadCredentialsException("User not found"));
        University university = universityRepository.findById(user.getIduniversity()).orElseThrow(() -> new BadCredentialsException("University not found"));
        return userDTOConverter(user,university);
    }
}
