package com.example.demo086.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo086.entity.user;
import com.example.demo086.exception.ResourceNotFound;
import com.example.demo086.repository.userrepo;

@Service
public class AuthService {

    private final PasswordEncoder encoder;
    private final userrepo userRepo;

    public AuthService(PasswordEncoder encoder, userrepo userRepo) {
        this.encoder = encoder;
        this.userRepo = userRepo;
    }

    public user register(user userData) {
        userData.setId(null);
        userData.setPassword(encoder.encode(userData.getPassword()));
        return userRepo.save(userData);
    }

    public boolean verifyPassword(String username, String password) {

        user userData = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return encoder.matches(password, userData.getPassword());
    }

    public List<user> getAllUsers() {
        return userRepo.findAll();
    }

    public user getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));
    }

    public user updateUser(Long id, user userData) {
        user existing = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));

        existing.setUsername(userData.getUsername());
        existing.setPassword(encoder.encode(userData.getPassword()));

        return userRepo.save(existing);
    }

    public user deleteUser(Long id) {
        user existing = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));

        userRepo.delete(existing);
        return existing;
    }

    public user patchUser(Long id, user userData) {
        user existing = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));

        if (userData.getUsername() != null)
            existing.setUsername(userData.getUsername());

        if (userData.getPassword() != null)
            existing.setPassword(encoder.encode(userData.getPassword()));

        return userRepo.save(existing);
    }
}
