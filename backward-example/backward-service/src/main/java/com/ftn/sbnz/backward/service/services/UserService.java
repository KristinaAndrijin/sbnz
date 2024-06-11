package com.ftn.sbnz.backward.service.services;

import com.ftn.sbnz.backward.service.models.User;
import com.ftn.sbnz.backward.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + username + " not found"));
        return user;
    }
}
