package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;

public interface TeacherRespositoryPort {
    
    List<Teacher> findAll(); 

    Teacher findById(Long idTeacher);

    Teacher findByCpf(String cpf);

    Teacher save(Teacher teacher);

    void update(Long idTeacher, Teacher teacher);

    void deleteById(Long idTeacher);
}
