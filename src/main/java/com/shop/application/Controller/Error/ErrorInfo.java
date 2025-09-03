package com.shop.application.Controller.Error;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorInfo {

    private final String details;
    private final int status;
    @JsonIgnore
    private final Exception exception;

    public ErrorInfo(HttpServletRequest request , String details , HttpStatus status , Exception exception){
        this.details = details;
        this.status = status.value();
        this.exception = exception;
    }

}
