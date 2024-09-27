package br.com.grimoire.hexagonalschool.domain.dto;

import java.time.LocalDateTime;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTeacherDTO {
    
    private String cpf;

    private String fullName;

    private String email;

    private LocalDateTime birthDate;

    private Double salary;


    public Teacher toTeacher(){
        return new Teacher(null, cpf, fullName, email, birthDate, salary, true);
    }
}
