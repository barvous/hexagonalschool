package br.com.grimoire.hexagonalschool.domain.models;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    public Long id;
    private CPF cpf;
    private String fullName;
    private String email;
    private LocalDate birthdate;
    private boolean userActive;

    public Person(Long id, String cpf, String fullName, String email, LocalDate birthdate, boolean userActive) {
        this.id = id;
        setCpf(cpf);
        setFullName(fullName);
        this.email = email;
        this.birthdate = birthdate;
        this.userActive = userActive;
    }

    public String getCpf() {
        return cpf.getCpfValue();
    }

    public void setCpf(String cpf) {
        this.cpf = new CPF(cpf);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    Integer getAge() {
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthdate, currentDate);

        return period.getYears();
    }

}
