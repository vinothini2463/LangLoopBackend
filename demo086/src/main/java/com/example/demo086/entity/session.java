package com.example.demo086.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class session {

    @Id
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Min(value = 0, message = "Score cannot be negative")
    private int score;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Deck ID is required")
    private Long deckId;

    public session() {
    }

    public session(Long id, LocalDateTime startTime, LocalDateTime endTime, int score, Long userId, Long deckId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
        this.userId = userId;
        this.deckId = deckId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }
}
