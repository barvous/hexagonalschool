package br.com.grimoire.hexagonalschool.domain.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    List<SchoolClass> listSchoolClass = new ArrayList<>();

    public Student(Long id, String cpf, String fullName, String email, LocalDate birthdate,
            List<SchoolClass> listSchoolClass,
            boolean userActive) {
        super(id, cpf, fullName, email, birthdate, userActive);
        this.listSchoolClass = listSchoolClass;
    }

    public List<SchoolClass> getListSchoolClass() {
        return listSchoolClass;
    }

    public void setListSchoolClass(List<SchoolClass> listSchoolClass) {
        this.listSchoolClass = listSchoolClass;
    }

    public void addSchoolClassIntoList(SchoolClass schoolClass) {
        this.listSchoolClass.add(schoolClass);
    }

    public void deleteSchoolClassFromList(SchoolClass schoolClass) {
        this.listSchoolClass.remove(schoolClass);
    }

    public void deleteSchoolClassFromList(Long schoolClassId) {
        this.listSchoolClass.removeIf(predicate -> predicate.getId().longValue() == schoolClassId);
    }

}
