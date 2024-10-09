package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterStudentDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowStudentDTO;

public interface StudentServicePort {

    List<ShowStudentDTO> findAll();

    ShowStudentDTO findById(Long idStudent);

    ShowStudentDTO save(RegisterStudentDTO registerStudentDTO);

    void update(RegisterStudentDTO registerStudentDTO, Long idStudent);

    void deleteById(Long idStudent);
}
