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

import com.example.demo086.entity.metric;
import com.example.demo086.services.metricservice;

@RestController
@RequestMapping("/api/metrics")
public class metriccontroller {

    @Autowired
    private metricservice cruduser;

    @PostMapping
    public ResponseEntity<metric> saveData(@RequestBody metric data) {
        metric savedMetric = cruduser.saveData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMetric);
    }

    @GetMapping
    public ResponseEntity<List<metric>> getData() {
        return ResponseEntity.ok(cruduser.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Long id) {
        try {
            metric getData = cruduser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metric not found");
        }
    }

    @PutMapping("/{id}")
    public metric updatedata(@PathVariable Long id, @RequestBody metric data) {
        return cruduser.updateDatabase(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id) {
        try {
            metric getData = cruduser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metric not found");
        }
    }

    @PatchMapping("/{id}")
    public metric patchData(@PathVariable Long id, @RequestBody metric data) {
        return cruduser.patchDatabase(id, data);
    }
}
