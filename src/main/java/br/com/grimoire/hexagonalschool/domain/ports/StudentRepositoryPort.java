package br.com.grimoire.hexagonalschool.domain.ports;

import br.com.grimoire.hexagonalschool.domain.models.Student;

public interface StudentRepositoryPort {

    Student findById(Long idStudent);

    Student findByCpf(String cpf);

    Student save(Student student);

    void update(Long idStudent, Student student);

    void delete(Long idStudent);
}
