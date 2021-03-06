package com.example.mitchellcoding.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException() {
        super();
    }

    public VehicleNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public VehicleNotFoundException(final String message) {
        super(message);
    }

    public VehicleNotFoundException(final Throwable cause) {
        super(cause);
    }
}