package br.com.grimoire.hexagonalschool.domain.dto;

import java.time.LocalDateTime;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowTeacherDTO {

    private Long id;
    private String cpf;
    private String fullName;
    private String email;
    private LocalDateTime birthdate;
    private Double salary;
    private boolean userActive;

    public ShowTeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.cpf = teacher.getCpf();
        this.fullName = teacher.getFullName();
        this.email = teacher.getEmail();
        this.birthdate = teacher.getBirthdate();
        this.salary = teacher.getSalary();
        this.userActive = teacher.isUserActive();
    }

}
