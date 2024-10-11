package br.com.grimoire.hexagonalschool.infra.exception;

public class InternalServerException extends RuntimeException {

    public InternalServerException(String message) {
        super(message);
    }
}
