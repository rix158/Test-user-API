package com.nisum.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomResourceException.class)
    public ResponseEntity<BodyError> customHandleNotFound(Exception ex, WebRequest request) {

        BodyError error = new BodyError();
        error.setMensaje(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);

    }
    
}
