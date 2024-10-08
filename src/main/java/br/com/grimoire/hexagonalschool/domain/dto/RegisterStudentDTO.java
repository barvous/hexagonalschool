package br.com.grimoire.hexagonalschool.domain.dto;

import java.time.LocalDateTime;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import br.com.grimoire.hexagonalschool.domain.models.Student;

import java.util.ArrayList;

public class RegisterStudentDTO {

    private String cpf;

    private String fullName;

    private String email;

    private LocalDateTime birthDate;

    private List<RegisterSchoolClassDTO> schoolClassList = new ArrayList<>();

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

    public List<RegisterSchoolClassDTO> getSchoolClass() {
        return schoolClassList;
    }

    public void setSchoolClass(List<RegisterSchoolClassDTO> schoolClassList) {
        this.schoolClassList = schoolClassList;
    }

    public Student toStudent() {
        List<SchoolClass> listSchoolClass = schoolClassList.stream().map(RegisterSchoolClassDTO::toSchoolClass)
                .toList();

        return new Student(null, cpf, fullName, email, birthDate, listSchoolClass, true);
    }

}
