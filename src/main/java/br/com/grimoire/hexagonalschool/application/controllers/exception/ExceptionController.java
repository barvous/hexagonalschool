package br.com.grimoire.hexagonalschool.application.controllers.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.NoHandlerFoundException;

import br.com.grimoire.hexagonalschool.domain.models.exception.BadRequestException;
import br.com.grimoire.hexagonalschool.domain.models.exception.InvalidSalaryException;
import br.com.grimoire.hexagonalschool.domain.models.exception.NotFoundException;
import br.com.grimoire.hexagonalschool.domain.models.exception.StandardError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<StandardError> internalServerException(InternalServerError e, HttpServletRequest request) {

        String message = e.getMessage();
        String error = "Internal Server Error";

        if (message == null)
            message = e.toString();

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(InvalidSalaryException.class)
    public ResponseEntity<StandardError> invalidSalaryException(InvalidSalaryException e, HttpServletRequest request) {

        String message = e.getMessage();
        String error = "Invalid Salary Error";

        if (message == null)
            message = e.toString();

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {

        String message = e.getMessage();
        String error = "Bad Request Error";

        if (message == null)
            message = e.toString();

        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request) {

        String message = e.getMessage();
        String error = "Not Found Error";

        if (message == null)
            message = e.toString();

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<StandardError> defaultNotFoundException(HttpServletRequest request) {
        String message = "Resource not found";
        String error = "Not Found";

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
