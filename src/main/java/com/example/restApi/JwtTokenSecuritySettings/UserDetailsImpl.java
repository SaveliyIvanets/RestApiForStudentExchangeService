package com.example.restApi.JwtTokenSecuritySettings;

import com.example.restApi.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String role;
    private Long idUniversity;
    private String fullname;
    private String programcode;

    public UserDetailsImpl(Long id, String name, String password, String email, String role, Long idUniversity,String fullname,String programcode ) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.idUniversity = idUniversity;
        this.fullname = fullname;
        this.programcode = programcode;
    }

    public static UserDetailsImpl build (User user){
        return new UserDetailsImpl(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getIduniversity(),
                user.getFullname(),
                user.getProgramCode()
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
