package com.example.demo086.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo086.entity.flashcard;
import com.example.demo086.exception.ResourceNotFound;
import com.example.demo086.repository.flashcardrepo;

@Service
public class flashcardservice {

    @Autowired
    flashcardrepo crudrepo;

    public flashcard saveData(flashcard data) {
        return crudrepo.save(data);
    }

    public List<flashcard> getAllData() {
        return crudrepo.findAll();
    }

    public flashcard getUserDetails(Long id) {
        return crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Flashcard not Found"));
    }

    public flashcard updateDatabase(Long id, flashcard data) {

        flashcard viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Flashcard not Found"));

        viewData.setFrontContent(data.getFrontContent());
        viewData.setBackContent(data.getBackContent());
        viewData.setOrderIndex(data.getOrderIndex());
        viewData.setDeckId(data.getDeckId());

        return crudrepo.save(viewData);
    }

    public flashcard getDelete(Long id) {

        flashcard viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Flashcard not Found"));

        crudrepo.delete(viewData);

        return viewData;
    }

    public flashcard patchDatabase(Long id, flashcard data) {

        flashcard viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Flashcard not Found"));

        viewData.setFrontContent(data.getFrontContent());
        viewData.setBackContent(data.getBackContent());
        viewData.setOrderIndex(data.getOrderIndex());
        viewData.setDeckId(data.getDeckId());

        return crudrepo.save(viewData);
    }
}
