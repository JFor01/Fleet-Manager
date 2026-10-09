package com.example.fleet_manager.src.trip;

public class NoTripException extends RuntimeException {
    public NoTripException(String message) {
        super(message);
    }
}
