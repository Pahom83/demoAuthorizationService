package ru.netology.demoauthorizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.demoauthorizationservice.exception.InvalidCredentials;
import ru.netology.demoauthorizationservice.exception.UnauthorizedUser;
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handlerInvalidCredentials(InvalidCredentials e){
        return ResponseEntity.badRequest().body("InvalidCredentials " + e.getMessage());
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handlerUnauthorizedUser(UnauthorizedUser e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnauthorizedUser " + e.getMessage());
    }
}
