package com.example.demo086.services;

import java.security.Key;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo086.entity.user;
import com.example.demo086.exception.ResourceNotFound;
import com.example.demo086.repository.userrepo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class userservice {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    public PasswordEncoder passwordEncode;

    @Autowired
    userrepo crudrepo;

    public user saveData(user data) {
        return crudrepo.save(data);
    }

    public List<user> getAllData() {
        return crudrepo.findAll();
    }

    public user getUserDetails(Long id) {
        return crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not Found"));
    }

    public user updateDatabase(Long id, user data) {

        user viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not Found"));

        viewData.setUsername(data.getUsername());
        viewData.setPassword(data.getPassword());
        viewData.setRole(data.getRole());

        return crudrepo.save(viewData);
    }

    public user getDelete(Long id) {

        user stu = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not Found"));

        crudrepo.delete(stu);

        return stu;
    }

    public user patchDatabase(Long id, user data) {

        user viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not Found"));

        viewData.setUsername(data.getUsername());
        viewData.setPassword(passwordEncode.encode(data.getPassword()));
        viewData.setRole(data.getRole());

        return crudrepo.save(viewData);
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + exp))
                .signWith(getKeys())
                .compact();
    }

    private Key getKeys() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
