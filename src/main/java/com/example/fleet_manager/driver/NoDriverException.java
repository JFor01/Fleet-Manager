package com.example.fleet_manager.driver;

public class NoDriverException extends RuntimeException {
    public NoDriverException(String message) {
        super(message);
    }
}
