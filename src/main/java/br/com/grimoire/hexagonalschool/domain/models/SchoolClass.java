package br.com.grimoire.hexagonalschool.domain.models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SchoolClass {

    private static final int HOURS_OF_STUDY_PER_DAY = 3;

    private String id;
    private String name;
    private String description;
    private Teacher teacher;
    private Duration completionTime;
    private LocalDateTime completionForecast;

    public SchoolClass(String id, String name, Teacher teacher, Duration completionTime) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.completionTime = completionTime;
        setCompletionTime(completionTime);

    }

    public SchoolClass(String id, String name, String description, Teacher teacher, Duration completionTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.completionTime = completionTime;
        setCompletionTime(completionTime);
    }

    LocalDateTime calculateCompletionForecast(Duration completionTime) {

        long classTotalHours = completionTime.toHours();
        long classTotalDays = (long) Math.ceil((double) classTotalHours / HOURS_OF_STUDY_PER_DAY);

        LocalDateTime completionDate = LocalDateTime.now().plus(classTotalDays, ChronoUnit.DAYS);

        return completionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Duration getCompletionTime() {
        return completionTime;
    }

    private void setCompletionTime(Duration completionTime) {
        this.completionForecast = calculateCompletionForecast(completionTime);
    }

    public LocalDateTime getCompletionForecast() {
        return completionForecast;
    }

}
