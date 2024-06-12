package com.ftn.sbnz.backward.service.services;

import com.ftn.sbnz.backward.service.models.Field;
import com.ftn.sbnz.backward.service.models.Student;
import com.ftn.sbnz.backward.service.models.User;
import com.ftn.sbnz.backward.service.repository.StudentRepository;
import com.ftn.sbnz.backward.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUsername(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            Random random = new Random();
            // User does not exist, create a new one
            Student user = new Student();
            user.setUsername(username);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            Field[] fields = Field.values();
            int randFiled = random.nextInt(fields.length);
            user.setField(fields[randFiled]);
//            userRepository.save(user);
            studentRepository.save(user);
            return user;
        }
        return userOpt.get();
    }
}
