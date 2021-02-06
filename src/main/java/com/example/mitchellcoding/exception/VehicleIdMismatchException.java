package com.example.mitchellcoding.exception;

public class VehicleIdMismatchException extends RuntimeException {

    public VehicleIdMismatchException() {
        super();
    }

    public VehicleIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public VehicleIdMismatchException(final String message) {
        super(message);
    }

    public VehicleIdMismatchException(final Throwable cause) {
        super(cause);
    }
}