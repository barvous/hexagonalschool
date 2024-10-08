package br.com.grimoire.hexagonalschool.domain.dto;

import java.sql.Time;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;

public class RegisterSchoolClassDTO {

    private String name;
    private String description;
    private Long idTeacher;
    private Time completionTime;
    private boolean finished;

    public RegisterSchoolClassDTO(String name, String description, Long idTeacher, Time completionTime,
            boolean finished) {
        this.name = name;
        this.description = description;
        this.idTeacher = idTeacher;
        this.completionTime = completionTime;
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

    public Time getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Time completionTime) {
        this.completionTime = completionTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public SchoolClass toSchoolClass() {
        return new SchoolClass(name, description, completionTime, false);

    }

}
