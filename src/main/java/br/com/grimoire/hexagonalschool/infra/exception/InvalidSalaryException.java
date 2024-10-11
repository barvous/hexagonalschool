package br.com.grimoire.hexagonalschool.infra.exception;

public class InvalidSalaryException extends RuntimeException {

    public InvalidSalaryException(String message) {
        super(message);
    }
}
