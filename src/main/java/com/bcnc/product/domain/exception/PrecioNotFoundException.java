package com.bcnc.product.domain.exception;

public class PrecioNotFoundException extends RuntimeException {
    public PrecioNotFoundException(String message) {
        super(message);
    }
}