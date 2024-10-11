package br.com.grimoire.hexagonalschool.domain.dto;

import java.time.LocalDateTime;

import br.com.grimoire.hexagonalschool.domain.models.Student;

public class RegisterStudentDTO {

    private String cpf;

    private String fullName;

    private String email;

    private LocalDateTime birthDate;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Student toStudent() {

        return new Student(null, cpf, fullName, email, birthDate, true);
    }

}
