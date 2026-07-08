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

import com.example.demo086.entity.deck;
import com.example.demo086.services.deckservice;

@RestController
@RequestMapping("/api/decks")
public class deckcontroller {

    @Autowired
    private deckservice cruduser;

    @PostMapping
    public ResponseEntity<deck> saveData(@RequestBody deck data) {
        deck savedDeck = cruduser.saveData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeck);
    }

    @GetMapping
    public ResponseEntity<List<deck>> getData() {
        return ResponseEntity.ok(cruduser.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Long id) {
        try {
            deck getData = cruduser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deck not found");
        }
    }

    @PutMapping("/{id}")
    public deck updatedata(@PathVariable Long id, @RequestBody deck data) {
        return cruduser.updateDatabase(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id) {
        try {
            deck getData = cruduser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deck not found");
        }
    }

    @PatchMapping("/{id}")
    public deck patchData(@PathVariable Long id, @RequestBody deck data) {
        return cruduser.patchDatabase(id, data);
    }
}
