package com.example.restApi.Repository;

import com.example.restApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findUsersByName(String name);
    Boolean existsUserByName(String name);
    Boolean existsUserByEmail(String Email);
    List<User> findByRoleAndIduniversity(String role,Long id);

}
