package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.Student;

public interface StudentRepositoryPort {

    List<Student> findAll();

    Student findById(Long idStudent);

    Student findByCpf(String cpf);

    Student save(Student student);

    void update(Long idStudent, Student student);

    void delete(Long idStudent);
}
