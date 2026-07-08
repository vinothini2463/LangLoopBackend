package com.example.demo086.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo086.entity.user;
import com.example.demo086.services.userservice;

@RestController

@RequestMapping("/api/users")
@PreAuthorize("hasRole('ADMIN')")
public class usercontroller {

    @Autowired
    private userservice cruduser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN'),('LEARNER')")
    public ResponseEntity<user> saveData(@RequestBody user data) {
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        user savedUser = cruduser.saveData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @GetMapping
    public ResponseEntity<List<user>> getData() {
        return ResponseEntity.ok(cruduser.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Long id) {
        try {
            user getData = cruduser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }
    }

    @PutMapping("/{id}")
    public user updatedata(@PathVariable Long id, @RequestBody user data) {
        return cruduser.updateDatabase(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id) {
        try {
            user getData = cruduser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }
    }

    @PatchMapping("/{id}")
    public user patchData(@PathVariable Long id, @RequestBody user data) {
        return cruduser.patchDatabase(id, data);
    }

    @PostMapping("/get/gmail")
    public String generateToken(@RequestParam("gmail") String gmail) {
        return cruduser.generateToken(gmail);
    }

}
