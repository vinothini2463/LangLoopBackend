package com.example.demo086.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String text) {
        super(text);
    }

}
