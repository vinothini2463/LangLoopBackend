package com.example.demo086.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo086.entity.deck;

@Repository
public interface deckrepo extends JpaRepository<deck, Long> {

}
