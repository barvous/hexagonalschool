package br.com.grimoire.hexagonalschool.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.Student;

public class ShowStudentDTO {

    private Long id;
    private String cpf;
    private String fullName;
    private String email;
    private LocalDateTime birthDate;
    private boolean userActive;
    private List<ShowSchoolClassDTO> schoolClassList;

    public ShowStudentDTO(Student student) {
        this.id = student.getId();
        this.cpf = student.getCpf();
        this.fullName = student.getFullName();
        this.email = student.getEmail();
        this.birthDate = student.getBirthdate();
        this.userActive = student.isUserActive();
        this.schoolClassList = student.getListSchoolClass()
                .stream()
                .map(ShowSchoolClassDTO::new)
                .toList();
    }

    public ShowStudentDTO(Long id, String cpf, String fullName, String email, LocalDateTime birthDate,
            boolean userActive, List<ShowSchoolClassDTO> schoolClassList) {
        this.id = id;
        this.cpf = cpf;
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
        this.userActive = userActive;
        this.schoolClassList = schoolClassList;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    public List<ShowSchoolClassDTO> getSchoolClassList() {
        return schoolClassList;
    }

    public void setSchoolClassList(List<ShowSchoolClassDTO> schoolClassList) {
        this.schoolClassList = schoolClassList;
    }

}
