package com.example.restApi.Controllers;

import com.example.restApi.DTO.SignInDTO;
import com.example.restApi.DTO.SignUpDTO;
import com.example.restApi.JwtTokenSecuritySettings.JwtCore;
import com.example.restApi.model.User;
import com.example.restApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtCore jwtCore;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtCore(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignUpDTO signUpDto) {
        if (userRepository.existsUserByName(signUpDto.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Choose different username");
        }
        if (userRepository.existsUserByEmail(signUpDto.getEmail())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Choose different email");
        }
        User user = new User();
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setFullname(signUpDto.getFullname());

        userRepository.save(user);
        return ResponseEntity.ok("Success, baby");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInDTO signinRequest) {
        try {
            // Сначала находим пользователя по имени
            User user = userRepository.findByName(signinRequest.getName())
                    .orElseThrow(() -> new BadCredentialsException("User not found"));

            // Проверяем пароль (сравниваем введенный пароль с хэшем из БД)
            if (!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
                throw new BadCredentialsException("Invalid password");
            }

            // Аутентификация
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signinRequest.getName(),
                            signinRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtCore.generateToken(authentication);
            return ResponseEntity.ok(jwt);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
