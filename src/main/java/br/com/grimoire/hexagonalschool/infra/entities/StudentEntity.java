package br.com.grimoire.hexagonalschool.infra.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import br.com.grimoire.hexagonalschool.domain.models.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STUDENT")
    private Long id;

    @Column(name = "CPF_STUDENT")
    private String cpf;

    @Column(name = "FULL_NAME_STUDENT")
    private String fullName;

    @Column(name = "EMAIL_STUDENT")
    private String email;

    @Column(name = "BIRTHDATE_STUDENT")
    private LocalDateTime birthDate;

    @Column(name = "FLAG_STUDENT_ACTIVE")
    private boolean studentActive;

    @OneToMany(mappedBy = "id.studentEntity")
    private List<SchoolClassStudent> listSchoolClass = new ArrayList<>();

    public StudentEntity(Student student) {
        this.id = student.getId();
        this.cpf = student.getCpf();
        this.fullName = student.getFullName();
        this.email = student.getEmail();
        this.birthDate = student.getBirthdate();
        this.studentActive = student.isUserActive();
        this.listSchoolClass = student.getListSchoolClass()
                .stream()
                .map(eachSchoolClass -> new SchoolClassStudent(this, new SchoolClassEntity(eachSchoolClass)))
                .toList();
    }

    public Student toStudent() {

        List<SchoolClass> schoolClassList = this.listSchoolClass.stream()
                .map(eachSchoolClassStudent -> eachSchoolClassStudent.getId().getSchoolClassEntity().toSchoolClass())
                .toList();
        return new Student(id, cpf, fullName, email, birthDate, schoolClassList, studentActive);
    }

}
