package com.digital.innovationone.gerenciadorDeSalasReuniao.exception;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        return new ResponseEntity(ErrorDetails.builder().timeStamp(new Date()).message(ex.getMessage()).details(webRequest.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }


}
