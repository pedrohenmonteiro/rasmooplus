package com.mont.rasmooplus.exception.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.exception.ExceptionResponse;
import com.mont.rasmooplus.exception.NotFoundException;

@RestControllerAdvice
public class ResourceHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(Exception ex, WebRequest req) {
        var exResponse = ExceptionResponse.builder()
            .timestamp(Instant.now())
            .message(ex.getMessage())
            .details(req.getDescription(false))
            .status(HttpStatus.NOT_FOUND.value())
        .build();
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exResponse);
    }
    

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> badRequestExceptionHandler(Exception ex, WebRequest req) {
        var exResponse = ExceptionResponse.builder()
            .timestamp(Instant.now())
            .message(ex.getMessage())
            .details(req.getDescription(false))
            .status(HttpStatus.BAD_REQUEST.value())
        .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponse);
    }
}
