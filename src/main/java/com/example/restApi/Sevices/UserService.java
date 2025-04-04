package com.example.restApi.Sevices;

import com.example.restApi.JwtTokenSecuritySettings.UserDetailsImpl;
import com.example.restApi.Repository.UserRepository;
import com.example.restApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;
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
}
