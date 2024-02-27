package com.example.gameshop.services.Impl;

import com.example.gameshop.models.User;
import com.example.gameshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordUpdateService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordUpdateService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void updatePasswords() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            // Encode the existing password
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            // Update the user with the encoded password
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }
    }
}
