package br.com.joshua.asyncbasic.controller.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class MainExceptionHandler {

	public record ErrorResponse(int status, String path, String message) {}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleTemporaryRedirectException(HttpServletRequest req, Exception e) {
    	e.printStackTrace();
    	log.info(e.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse(307, req.getServletPath(), e.getMessage()));
    }
	
}
