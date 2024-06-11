package com.ftn.sbnz.backward.service.repository;

import com.ftn.sbnz.backward.service.models.User;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
