package br.com.grimoire.hexagonalschool.infra.entities;

import java.time.LocalDateTime;

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

    @Column(name = "BIRTHDATE_STUDENT")
    private LocalDateTime birthDate;

    //SchoolClass and Student its a n:n relationship.
    //TODO: Create a middle-class between these two

    // @OneToMany(mappedBy = "student")
    // private List<SchoolClassEntity> listSchoolClass = new ArrayList<>();

}
