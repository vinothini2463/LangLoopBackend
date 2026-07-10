package com.example.demo086.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Front content is required")
    private String frontContent;

    @NotBlank(message = "Back content is required")
    private String backContent;

    @Positive(message = "Order index must be greater than 0")
    private int orderIndex;

    private Long deckId;

    public flashcard() {
    }

    public flashcard(Long id, String frontContent, String backContent, int orderIndex, Long deckId) {
        this.id = id;
        this.frontContent = frontContent;
        this.backContent = backContent;
        this.orderIndex = orderIndex;
        this.deckId = deckId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrontContent() {
        return frontContent;
    }

    public void setFrontContent(String frontContent) {
        this.frontContent = frontContent;
    }

    public String getBackContent() {
        return backContent;
    }

    public void setBackContent(String backContent) {
        this.backContent = backContent;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }
}
