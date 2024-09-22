package br.com.grimoire.hexagonalschool.domain.models;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    public Long id;
    private CPF cpf;
    private String fullName;
    public LocalDate birthdate;

    public Person(Long id, String cpf, String fullName, LocalDate birthdate) {
        this.id = id;
        setCpf(cpf);
        setFullName(fullName);
        this.birthdate = birthdate;
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

    Integer getAge() {
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthdate, currentDate);

        return period.getYears();
    }

}
