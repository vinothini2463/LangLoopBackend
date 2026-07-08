package com.example.demo086.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class metric {

    @Id
    private Long id;

    @Positive(message = "Ease factor must be positive")
    private Double easeFactor;

    @Positive(message = "Interval must be positive")
    private int intervalDays;

    private LocalDateTime nextReviewDate;

    public metric() {
    }

    public metric(Long id, Double easeFactor, int intervalDays, LocalDateTime nextReviewDate) {
        this.id = id;
        this.easeFactor = easeFactor;
        this.intervalDays = intervalDays;
        this.nextReviewDate = nextReviewDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getEaseFactor() {
        return easeFactor;
    }

    public void setEaseFactor(Double easeFactor) {
        this.easeFactor = easeFactor;
    }

    public int getIntervalDays() {
        return intervalDays;
    }

    public void setIntervalDays(int intervalDays) {
        this.intervalDays = intervalDays;
    }

    public LocalDateTime getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(LocalDateTime nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }
}
