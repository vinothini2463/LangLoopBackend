package com.example.demo086.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo086.entity.metric;
import com.example.demo086.exception.ResourceNotFound;
import com.example.demo086.repository.metricrepo;

@Service
public class metricservice {

    @Autowired
    metricrepo crudrepo;

    public metric saveData(metric data) {
        return crudrepo.save(data);
    }

    public List<metric> getAllData() {
        return crudrepo.findAll();
    }

    public metric getUserDetails(Long id) {
        return crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Metric not Found"));
    }

    public metric updateDatabase(Long id, metric data) {

        metric viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Metric not Found"));

        viewData.setEaseFactor(data.getEaseFactor());
        viewData.setIntervalDays(data.getIntervalDays());
        viewData.setNextReviewDate(data.getNextReviewDate());

        return crudrepo.save(viewData);
    }

    public metric getDelete(Long id) {

        metric viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Metric not Found"));

        crudrepo.delete(viewData);

        return viewData;
    }

    public metric patchDatabase(Long id, metric data) {

        metric viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Metric not Found"));

        viewData.setEaseFactor(data.getEaseFactor());
        viewData.setIntervalDays(data.getIntervalDays());
        viewData.setNextReviewDate(data.getNextReviewDate());

        return crudrepo.save(viewData);
    }
}
