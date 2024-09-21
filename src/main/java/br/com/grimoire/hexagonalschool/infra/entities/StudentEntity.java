package br.com.grimoire.hexagonalschool.infra.entities;

import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;

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

}
