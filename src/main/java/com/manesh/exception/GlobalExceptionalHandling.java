package com.manesh.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionalHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),null);
        return handleExceptionInternal(ex, errorResponse, null, HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldError = result.getFieldErrors();
        List<String> errors = new ArrayList<>();
        for(FieldError error : fieldError) {
            errors.add(error.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"Bad request", errors);
        return this.handleExceptionInternal(ex, errorResponse, headers, status, request);
    }

    @Override
    protected ResponseEntity <Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        List<String> errors = new ArrayList<>();
        errors.add(error);
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getLocalizedMessage(), Collections.singletonList(error));
        return this.handleExceptionInternal(ex, errorResponse, headers, status, request);
    }

}
