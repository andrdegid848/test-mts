package com.mts.testmts.http.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.mts.testmts.http.controller")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
