package org.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.userservice.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailIgnoreCase(String email);
}