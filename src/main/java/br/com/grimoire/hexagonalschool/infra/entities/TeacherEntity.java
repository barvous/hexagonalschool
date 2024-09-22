package br.com.grimoire.hexagonalschool.infra.entities;

import java.time.LocalDate;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TEACHER")
    private Long id;

    @Column(name = "CPF_TEACHER")
    private String cpf;

    @Column(name = "FULL_NAME_TEACHER")
    private String fullName;

    @Column(name = "EMAIL_TEACHER")
    private String email;

    @Column(name = "SALARY_TEACHER")
    private Double salary;

    @Column(name = "BIRTHDATE_TEACHER")
    private LocalDate birthDate;

    @Column(name = "FLAG_TEACHER_ACTIVE")
    private boolean teacherActive;

    public Teacher toTeacher() {
        Teacher teacher = new Teacher(id, cpf, fullName, birthDate, salary);
        return teacher;
    }
}
