package com.nisum.users.controller;

import com.nisum.users.exception.CustomResourceException;
import com.nisum.users.model.User;
import com.nisum.users.repository.UserRepository;
import com.nisum.users.service.RegexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RegexValidator readProp;

    @GetMapping("/retrieve")
    public List<User> getAllUserList() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {

        //Search profile by email for validate before create new user
        if (userRepository.findByEmail(user.getEmail()).isEmpty()) {

            //Email validator regex
            if (readProp.emailPatternValidate(user.getEmail())) {
                if (readProp.passPatternValidate(user.getPassword())) {
                    user.setId(UUID.randomUUID());
                    user.setCreated(Date.from(Instant.now()));
                    user.setModified(Date.from(Instant.now()));
                    user.setLastLogin(user.getCreated());
                    user.setToken(user.getId().toString());
                    user.setIsActive(true);
                    User savedUser = userRepository.save(user);

                    return ResponseEntity.status(201).body(user);

                } else {

                    throw new CustomResourceException("Password invalid");
                }
            } else {

                throw new CustomResourceException("Email format invalid");
            }

        } else {

            throw new CustomResourceException("This email already exists");
        }

    }

}
