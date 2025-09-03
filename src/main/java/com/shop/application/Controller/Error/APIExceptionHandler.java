package com.shop.application.Controller.Error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shop.application.Exception.EntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class APIExceptionHandler extends  ResponseEntityExceptionHandler {



    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo handleEntityNotFoundException(HttpServletRequest httpServletRequest ,EntityNotFoundException exception){
        String message = exception.getMessage();
        return new ErrorInfo(httpServletRequest , message, HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleIllegalArgumentException(HttpServletRequest httpServletRequest ,IllegalArgumentException exception){
        String message = exception.getMessage();
        return new ErrorInfo(httpServletRequest , message, HttpStatus.BAD_REQUEST, exception);
    }

}
