package com.example.final_project_shop.shape.exception;

public class ShapeException extends Exception {
    public ShapeException() {
    }

    public ShapeException(String message) {
        super(message);
    }

    public ShapeException(Throwable cause) {
        super(cause);
    }

    public ShapeException(String message, Throwable cause) {
        super(message, cause);
    }
}

