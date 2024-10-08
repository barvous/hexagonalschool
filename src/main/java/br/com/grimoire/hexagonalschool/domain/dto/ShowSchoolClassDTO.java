package br.com.grimoire.hexagonalschool.domain.dto;

import java.sql.Time;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;

public class ShowSchoolClassDTO {
    
    private Long id;
    private String name;
    private String description;
    private ShowTeacherDTO teacher;
    private Time completionTime;
    private boolean finished;

    public ShowSchoolClassDTO(SchoolClass schoolClass) {
        this.id = schoolClass.getId();
        this.name = schoolClass.getName();
        this.description = schoolClass.getDescription();
        this.teacher = new ShowTeacherDTO(schoolClass.getTeacher());
        this.completionTime = schoolClass.getCompletionTime();
        this.finished = schoolClass.isFinished();

    }

    public ShowSchoolClassDTO(Long id, String name, String description, ShowTeacherDTO teacher, Time completionTime,
            boolean finished) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.completionTime = completionTime;
        this.finished = finished;
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

    public ShowTeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(ShowTeacherDTO teacher) {
        this.teacher = teacher;
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

    

    
}
