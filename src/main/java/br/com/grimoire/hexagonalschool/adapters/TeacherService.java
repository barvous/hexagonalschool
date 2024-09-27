package br.com.grimoire.hexagonalschool.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import br.com.grimoire.hexagonalschool.domain.ports.TeacherRespositoryPort;
import br.com.grimoire.hexagonalschool.domain.ports.TeacherServicePort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService implements TeacherServicePort {

    private final TeacherRespositoryPort teacherRespositoryPort;

    @Override
    public List<Teacher> findAll() {
        return teacherRespositoryPort.findAll();
    }

    // TODO: Create a DTO to show data for the user
    @Override
    public Teacher findById(Long idTeacher) {
        return teacherRespositoryPort.findById(idTeacher);
    }

    @Override
    public Teacher save(RegisterTeacherDTO registerTeacherDTO) {
        return teacherRespositoryPort.save(registerTeacherDTO.toTeacher());

    }

    @Override
    public void update(Long idTeacher, RegisterTeacherDTO registerTeacherDTO) {
        teacherRespositoryPort.update(idTeacher, registerTeacherDTO.toTeacher());

    }

    @Override
    public void delete(Long idTeacher) {
        teacherRespositoryPort.deleteById(idTeacher);
    }

}
