package br.com.grimoire.hexagonalschool.domain.models.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
