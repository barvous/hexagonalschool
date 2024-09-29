package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowTeacherDTO;

public interface TeacherServicePort {
    
    List<ShowTeacherDTO> findAll();

    ShowTeacherDTO findById(Long idTeacher);

    ShowTeacherDTO save(RegisterTeacherDTO registerTeacherDTO);

    void update(Long idTeacher, RegisterTeacherDTO registerTeacherDTO);

    void delete(Long idTeacher);
}
