package br.com.grimoire.hexagonalschool.domain.dto;

import java.time.LocalDateTime;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

}
