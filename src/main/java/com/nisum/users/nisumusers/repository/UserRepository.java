package com.nisum.users.nisumusers.repository;

import com.nisum.users.nisumusers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
