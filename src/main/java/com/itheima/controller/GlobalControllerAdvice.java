package com.itheima.controller;

import groovy.util.logging.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public String customerRuntimeExceptionHandler(UnauthorizedException exception) {
        return exception.getMessage();
    }

}