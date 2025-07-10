package com.wearl.HelloSpringBoot.exception;

import java.time.LocalDateTime;

public class ApiError {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ApiError(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public ApiError(String message, String details) {
        this(message, details, LocalDateTime.now());
    }

    // Getters and setters (or use Lombok @Data if preferred)

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
