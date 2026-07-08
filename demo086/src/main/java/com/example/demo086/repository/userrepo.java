package com.example.demo086.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo086.entity.user;
import java.util.Optional;

@Repository
public interface userrepo extends JpaRepository<user, Long> {
    Optional<user> findByUsername(String username);
}
