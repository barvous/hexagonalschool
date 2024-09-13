package br.com.grimoire.hexagonalschool.domain.models.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
