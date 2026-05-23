package com.example.mylibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> tratarRuntimeException(RuntimeException ex) {
        ErroResponse erro = new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de regra de negócio",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarException(Exception ex) {
        ErroResponse erro = new ErroResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno do servidor",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}