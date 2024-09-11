package br.com.grimoire.hexagonalschool.domain.models;

import java.time.LocalDate;

public class Teacher extends Person {

    // If salary has more complex logic, i would create a class for it
    private static final Double MINIMUM_WAGE = 1200.00;

    private Double salary;

    public Teacher(String cpf, String fullName, LocalDate birthdate, Double salary) {
        super(cpf, fullName, birthdate);
        setSalary(salary);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {

        if (salary == null) {
            throw new RuntimeException("The salary must not be null");
        }

        if (salary < MINIMUM_WAGE) {
            // TODO: Create a custom exception for this
            throw new RuntimeException("The provided salary is lower than the minimum wage");
        }
        this.salary = salary;
    }

}
