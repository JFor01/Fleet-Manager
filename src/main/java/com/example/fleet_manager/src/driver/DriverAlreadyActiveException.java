package com.example.fleet_manager.src.driver;

public class DriverAlreadyActiveException extends RuntimeException {
    public DriverAlreadyActiveException(String message) {
        super(message);
    }
}
