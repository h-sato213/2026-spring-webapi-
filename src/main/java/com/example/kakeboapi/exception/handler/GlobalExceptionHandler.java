package com.example.kakeboapi.exception.handler;

import com.example.kakeboapi.exception.KakeboArgumentNotValidException;
import com.example.kakeboapi.exception.KakeboNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KakeboNotFoundException.class)
    public ResponseEntity<String> handleKakeboNotFoundException(KakeboNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(KakeboArgumentNotValidException.class)
    public ResponseEntity<String> handleKakeboArgumentNotValidException(KakeboArgumentNotValidException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
