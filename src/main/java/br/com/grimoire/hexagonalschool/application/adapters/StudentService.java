package br.com.grimoire.hexagonalschool.application.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterStudentDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowStudentDTO;
import br.com.grimoire.hexagonalschool.domain.models.Student;
import br.com.grimoire.hexagonalschool.domain.ports.StudentRepositoryPort;
import br.com.grimoire.hexagonalschool.domain.ports.StudentServicePort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentRepositoryPort studentRepositoryPort;

    @Override
    public List<ShowStudentDTO> findAll() {
        return studentRepositoryPort.findAll()
                .stream()
                .map(student -> new ShowStudentDTO(student))
                .toList();
    }

    @Override
    public ShowStudentDTO findById(Long idStudent) {
        Student studentDB = studentRepositoryPort.findById(idStudent);
        return new ShowStudentDTO(studentDB);
    }

    @Override
    public ShowStudentDTO save(RegisterStudentDTO registerStudentDTO) {
        Student studentDB = studentRepositoryPort.save(registerStudentDTO.toStudent());
        return new ShowStudentDTO(studentDB);
    }

    @Override
    public void update(RegisterStudentDTO registerStudentDTO, Long idStudent) {
        studentRepositoryPort.update(idStudent, registerStudentDTO.toStudent());
    }

    @Override
    public void deleteById(Long idStudent) {
        studentRepositoryPort.delete(idStudent);
    }

}
