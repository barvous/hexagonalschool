package br.com.grimoire.hexagonalschool.domain.models;

import java.time.LocalDateTime;

import br.com.grimoire.hexagonalschool.infra.exception.InvalidSalaryException;

public class Teacher extends Person {

    // If salary has more complex logic, create a class for it
    private static final Double MINIMUM_WAGE_IN_REAIS = 1200.00;

    private Double salary;

    public Teacher(Long id, String cpf, String fullName, String email, LocalDateTime birthdate, Double salary,
            boolean userActive) {
        super(id, cpf, fullName, email, birthdate, userActive);
        setSalary(salary);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {

        if (salary == null) {
            throw new InvalidSalaryException("The salary must not be null");
        }

        if (salary < MINIMUM_WAGE_IN_REAIS) {
            throw new InvalidSalaryException("The provided salary is lower than the minimum wage. The minimum wage is R$" + MINIMUM_WAGE_IN_REAIS);
        }
        this.salary = salary;
    }

}
