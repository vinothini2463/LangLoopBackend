package com.example.demo086.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo086.entity.deck;
import com.example.demo086.exception.ResourceNotFound;
import com.example.demo086.repository.deckrepo;

@Service
public class deckservice {

    @Autowired
    deckrepo crudrepo;

    public deck saveData(deck data) {
        return crudrepo.save(data);
    }

    public List<deck> getAllData() {
        return crudrepo.findAll();
    }

    public deck getUserDetails(Long id) {
        return crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Deck not Found"));
    }

    public deck updateDatabase(Long id, deck data) {

        deck viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Deck not Found"));

        viewData.setTitle(data.getTitle());
        viewData.setDescription(data.getDescription());
        viewData.setCapacity(data.getCapacity());
        viewData.setMentorName(data.getMentorName());
        viewData.setOwnerId(data.getOwnerId());

        return crudrepo.save(viewData);
    }

    public deck getDelete(Long id) {

        deck viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Deck not Found"));

        crudrepo.delete(viewData);

        return viewData;
    }

    public deck patchDatabase(Long id, deck data) {

        deck viewData = crudrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Deck not Found"));

        viewData.setTitle(data.getTitle());
        viewData.setDescription(data.getDescription());
        viewData.setCapacity(data.getCapacity());
        viewData.setMentorName(data.getMentorName());
        viewData.setOwnerId(data.getOwnerId());

        return crudrepo.save(viewData);
    }
}
