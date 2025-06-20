package com.example.alumniconnect.repository;

import com.example.alumniconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find a user by email
    Optional<User> findByEmail(String email);

    // Optional: Add more query methods as needed, like:
    // Optional<User> findByEmailAndRole(String email, String role);
}
