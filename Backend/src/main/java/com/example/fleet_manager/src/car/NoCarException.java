package com.example.fleet_manager.src.car;

public class NoCarException extends RuntimeException {
    public NoCarException(String message) {
        super(message);
    }
}
