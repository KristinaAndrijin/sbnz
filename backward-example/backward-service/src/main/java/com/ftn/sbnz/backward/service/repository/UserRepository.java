package com.ftn.sbnz.backward.service.repository;

import com.ftn.sbnz.backward.service.models.Subject;
import com.ftn.sbnz.backward.service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
}
