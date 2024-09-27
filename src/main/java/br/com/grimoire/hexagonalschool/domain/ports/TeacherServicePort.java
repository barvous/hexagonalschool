package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.models.Teacher;

public interface TeacherServicePort {
    
    List<Teacher> findAll();

    Teacher findById(Long idTeacher);

    Teacher save(RegisterTeacherDTO registerTeacherDTO);

    void update(Long idTeacher, RegisterTeacherDTO registerTeacherDTO);

    void delete(Long idTeacher);
}
