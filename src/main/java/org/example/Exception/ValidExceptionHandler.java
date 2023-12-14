package org.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidExceptionHandler {

    @ExceptionHandler(ValidExceptionPlus.class)
    public ResponseEntity<?> handlerBadRequastPlus(ValidExceptionPlus e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Значение должно быть больше 0!");
    }
    @ExceptionHandler(ValidExceptionMinus.class)
    public ResponseEntity<?> handlerBadRequastMinus(ValidExceptionMinus e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Значение должно быть меньше 0!");
    }
}
