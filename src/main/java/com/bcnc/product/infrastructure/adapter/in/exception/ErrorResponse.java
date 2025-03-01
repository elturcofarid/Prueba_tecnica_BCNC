package com.bcnc.product.infrastructure.adapter.in.exception;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ErrorResponse {
    
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private int status;

    public ErrorResponse(String message, String path, int status) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.path = path;
        this.status = status;
    }

}