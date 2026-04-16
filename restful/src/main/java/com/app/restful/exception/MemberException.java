package com.app.restful.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MemberException extends RuntimeException{

    private HttpStatus status;

    public MemberException() {;}
    public MemberException(String message, HttpStatus status) {
        super(message);
    }
}
