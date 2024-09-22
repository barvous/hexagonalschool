package br.com.grimoire.hexagonalschool.domain.ports;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;

public interface TeacherRespositoryPort {
    
    Teacher findById(Long idTeacher);

    Teacher findByCpf(String cpf);

    Teacher save(Teacher teacher);

    void update(Long idTeacher, Teacher teacher);

    void delete(Long idTeacher);
}
