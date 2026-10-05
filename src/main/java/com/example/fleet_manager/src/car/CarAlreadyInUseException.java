package com.example.fleet_manager.src.car;

public class CarAlreadyInUseException extends RuntimeException {
    public CarAlreadyInUseException(String message) {
        super(message);
    }
}
