package br.com.grimoire.hexagonalschool.domain.models;

import java.sql.Time;

public class SchoolClass {

    private Long id;
    private String name;
    private String description;
    private Teacher teacher;
    private Time completionTime;
    private boolean finished;

    public SchoolClass(Long id, String name, Teacher teacher, Time completionTime) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.completionTime = completionTime;
        setCompletionTime(completionTime);

    }

    public SchoolClass(String name, String description, Teacher teacher, Time completionTime, boolean finished) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.completionTime = completionTime;
        this.finished = finished;
    }

    public SchoolClass(Long id, String name, String description, Teacher teacher, Time completionTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.completionTime = completionTime;
        setCompletionTime(completionTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Time getCompletionTime() {
        return completionTime;
    }

    private void setCompletionTime(Time completionTime) {
        this.completionTime = completionTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
