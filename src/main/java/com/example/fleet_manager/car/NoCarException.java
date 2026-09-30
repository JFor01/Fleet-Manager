package com.example.fleet_manager.car;

public class NoCarException extends RuntimeException {
    public NoCarException(String message) {
        super(message);
    }
}
