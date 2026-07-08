package com.example.demo086.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo086.entity.session;
import com.example.demo086.services.sessionservice;

@RestController
@RequestMapping("/api/sessions")
public class sessioncontroller {

    @Autowired
    private sessionservice cruduser;

    @PostMapping
    public ResponseEntity<session> saveData(@RequestBody session data) {
        session savedSession = cruduser.saveData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSession);
    }

    @GetMapping
    public ResponseEntity<List<session>> getData() {
        return ResponseEntity.ok(cruduser.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Long id) {
        try {
            session getData = cruduser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }
    }

    @PutMapping("/{id}")
    public session updatedata(@PathVariable Long id, @RequestBody session data) {
        return cruduser.updateDatabase(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id) {
        try {
            session getData = cruduser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }
    }

    @PatchMapping("/{id}")
    public session patchData(@PathVariable Long id, @RequestBody session data) {
        return cruduser.patchDatabase(id, data);
    }
}
