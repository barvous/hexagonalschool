package br.com.grimoire.hexagonalschool.domain.models.exception;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable {

    private String error;
    private String message;
    private Date currentDate;
    private Integer status;
    private String path;

    public StandardError() {
    }

    public StandardError(String error, Integer status, String message, Date currentDate) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.currentDate = currentDate;
    }

    public StandardError(String error, String message, Date currentDate, Integer status, String path) {
        this.error = error;
        this.message = message;
        this.currentDate = currentDate;
        this.status = status;
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
