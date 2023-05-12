package com.mont.rasmooplus.exception.handler;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity<ExceptionResponse> handleNotFoundExceptionHandler(Exception ex, WebRequest req) {
        var exResponse = ExceptionResponse.builder()
            .timestamp(Instant.now())
            .message(ex.getMessage())
            .details(req.getDescription(false))
            .status(HttpStatus.NOT_FOUND.value())
        .build();
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exResponse);
    }
    

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestExceptionHandler(Exception ex, WebRequest req) {
        var exResponse = ExceptionResponse.builder()
            .timestamp(Instant.now())
            .message(ex.getMessage())
            .details(req.getDescription(false))
            .status(HttpStatus.BAD_REQUEST.value())
        .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponse);
    }
    

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    //     @Override
    //     public ResponseEntity<Object> handleMethodArgumentNotValid(
	// 		MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req) {
        
    //     Map<String, String> messages = new HashMap<>();
        
    //     ex.getBindingResult().getAllErrors().forEach(error -> {
    //         String field = ((FieldError) error).getField();
    //         String message = error.getDefaultMessage();

    //         messages.put(field, message);
    //     });
    
        
    //     var exResponse = ExceptionResponse.builder()
    //         .timestamp(Instant.now())
    //         .message(Arrays.toString(messages.entrySet().toArray()))
    //         .details(req.getDescription(false))
    //         .status(HttpStatus.BAD_REQUEST.value())
    //     .build();

    //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponse);
    // }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException(Exception ex, WebRequest req) {
        var exResponse = ExceptionResponse.builder()
            .timestamp(Instant.now())
            .message(ex.getMessage())
            .details(req.getDescription(false))
            .status(HttpStatus.BAD_REQUEST.value())
        .build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponse);
    }
 
}
