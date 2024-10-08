package br.com.grimoire.hexagonalschool.domain.dto;

import java.sql.Time;

public class RegisterSchoolClassDTO {

    private String name;
    private String description;
    private Long idTeacher;
    private Time comppletionTime;
    private boolean finished;
    
    public RegisterSchoolClassDTO() {
    }

    public RegisterSchoolClassDTO(String name, String description, Long idTeacher, Time comppletionTime,
            boolean finished) {
        this.name = name;
        this.description = description;
        this.idTeacher = idTeacher;
        this.comppletionTime = comppletionTime;
        this.finished = finished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Time getComppletionTime() {
        return comppletionTime;
    }

    public void setComppletionTime(Time comppletionTime) {
        this.comppletionTime = comppletionTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
