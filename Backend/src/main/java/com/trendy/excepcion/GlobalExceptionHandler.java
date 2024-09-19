package com.trendy.excepcion;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        Map<String, Object> responseBody = new HashMap<>();
        exc.getBindingResult().getFieldErrors().forEach(error ->
                responseBody.put(error.getField(), error.getDefaultMessage())
        );
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException exc) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", exc.getMessage());
        responseBody.put("field", exc.getHttpInputMessage());
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatedDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, Object>> handleEmailAlreadyExistsException(DuplicatedDataException exc) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", exc.getMessage());
        responseBody.put("status", HttpStatus.CONFLICT.value());
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException exc) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", exc.getMessage());
        responseBody.put("status", HttpStatus.NOT_FOUND.value());
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException exc) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Error de validación: " + exc.getMessage());
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Map<String, Object>> handleBadCredentialsException(BadCredentialsException exc) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Error de validación: " + exc.getMessage());
        responseBody.put("status", HttpStatus.UNAUTHORIZED.value());
        responseBody.put("error", "No autorizado");
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JWTVerificationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Map<String, Object>> handleJWTVerificationException(JWTVerificationException exc){
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "JWT: " + exc.getMessage());
        responseBody.put("status", HttpStatus.UNAUTHORIZED.value());
        responseBody.put("timeStamp", currentTime());
        return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
    }

    private String currentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
