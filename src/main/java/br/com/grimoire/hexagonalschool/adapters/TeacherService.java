package br.com.grimoire.hexagonalschool.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import br.com.grimoire.hexagonalschool.domain.ports.TeacherRespositoryPort;
import br.com.grimoire.hexagonalschool.domain.ports.TeacherServicePort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService implements TeacherServicePort {

    private final TeacherRespositoryPort teacherRespositoryPort;

    @Override
    public List<ShowTeacherDTO> findAll() {
        return teacherRespositoryPort.findAll().stream().map(ShowTeacherDTO::new).toList();
    }

    @Override
    public ShowTeacherDTO findById(Long idTeacher) {
        Teacher teacher = teacherRespositoryPort.findById(idTeacher);
        return new ShowTeacherDTO(teacher);
    }

    @Override
    public ShowTeacherDTO save(RegisterTeacherDTO registerTeacherDTO) {
        Teacher teacherDB = teacherRespositoryPort.save(registerTeacherDTO.toTeacher());

        return new ShowTeacherDTO(teacherDB);

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
