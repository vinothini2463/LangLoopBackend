package com.example.demo086.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo086.entity.session;
import com.example.demo086.exception.ResourceNotFound;
import com.example.demo086.repository.sessionrepo;

@Service
public class sessionservice {

    @Autowired
    sessionrepo crudrepo;

    public session saveData(session data) {
        return crudrepo.save(data);
    }

    public List<session> getAllData() {
        return crudrepo.findAll();
    }

    public session getUserDetails(Long id) {
        return crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Session not Found"));
    }

    public session updateDatabase(Long id, session data) {

        session viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Session not Found"));

        viewData.setStartTime(data.getStartTime());
        viewData.setEndTime(data.getEndTime());
        viewData.setScore(data.getScore());
        viewData.setUserId(data.getUserId());
        viewData.setDeckId(data.getDeckId());

        return crudrepo.save(viewData);
    }

    public session getDelete(Long id) {

        session viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Session not Found"));

        crudrepo.delete(viewData);

        return viewData;
    }

    public session patchDatabase(Long id, session data) {

        session viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Session not Found"));

        viewData.setStartTime(data.getStartTime());
        viewData.setEndTime(data.getEndTime());
        viewData.setScore(data.getScore());
        viewData.setUserId(data.getUserId());
        viewData.setDeckId(data.getDeckId());

        return crudrepo.save(viewData);
    }
}
