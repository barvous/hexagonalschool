package br.com.grimoire.hexagonalschool.domain.models.exception;

public class InternalServerException extends RuntimeException {

    public InternalServerException(String message) {
        super(message);
    }
}
