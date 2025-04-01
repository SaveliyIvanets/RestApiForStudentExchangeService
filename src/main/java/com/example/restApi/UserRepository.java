package com.example.restApi;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findUsersByName(String name);
    Boolean existsUserByName(String name);
    Boolean existsUserByEmail(String Email);

}
