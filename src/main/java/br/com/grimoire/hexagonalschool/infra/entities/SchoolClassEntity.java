package br.com.grimoire.hexagonalschool.infra.entities;

import java.sql.Time;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHOOL_CLASS")
    private Long id;

    @Column(name = "NAME_SCHOOL_CLASS")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_TEACHER")
    private TeacherEntity teacher;

    @Column(name = "COMPLETION_TIME_SCHOOL_CLASS")
    private Time completionTime;

    @Column(name = "FLAG_FINISHED")
    private boolean finished;

    public SchoolClassEntity(SchoolClass schoolClass) {
        this.id = schoolClass.getId();
        this.name = schoolClass.getName();
        this.description = schoolClass.getDescription();
        this.teacher = new TeacherEntity(schoolClass.getTeacher());
        this.completionTime = schoolClass.getCompletionTime();
        this.finished = schoolClass.isFinished();
    }

    public SchoolClass toSchoolClass() {
        return new SchoolClass(id, name, description, teacher.toTeacher(), completionTime);

    }

}
