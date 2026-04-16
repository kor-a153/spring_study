package com.app.restful.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PostException extends RuntimeException {
    public PostException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
