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

import com.example.demo086.entity.flashcard;
import com.example.demo086.services.flashcardservice;

@RestController
@RequestMapping("/api/flashcards")
public class flashcardcontroller {

    @Autowired
    private flashcardservice cruduser;

    @PostMapping
    public ResponseEntity<flashcard> saveData(@RequestBody flashcard data) {
        flashcard savedFlashcard = cruduser.saveData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlashcard);
    }

    @GetMapping
    public ResponseEntity<List<flashcard>> getData() {
        return ResponseEntity.ok(cruduser.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Long id) {
        try {
            flashcard getData = cruduser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flashcard not found");
        }
    }

    @PutMapping("/{id}")
    public flashcard updatedata(@PathVariable Long id, @RequestBody flashcard data) {
        return cruduser.updateDatabase(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id) {
        try {
            flashcard getData = cruduser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flashcard not found");
        }
    }

    @PatchMapping("/{id}")
    public flashcard patchData(@PathVariable Long id, @RequestBody flashcard data) {
        return cruduser.patchDatabase(id, data);
    }
}
