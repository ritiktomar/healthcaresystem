package com.capgemini.hcm.controller;


import com.capgemini.hcm.exception.CenterException;
import com.capgemini.hcm.exception.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class DiagnosticCenterAdvice {
    @ExceptionHandler(value = {CenterException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorInfo handleException1(Exception ex) {
        return new ErrorInfo(ex.getMessage());
    }
}
