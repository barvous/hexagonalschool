package br.com.grimoire.hexagonalschool.domain.models.exception;

public class InvalidSalaryException extends RuntimeException {

    public InvalidSalaryException(String message) {
        super(message);
    }
}
