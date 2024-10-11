package br.com.grimoire.hexagonalschool.application.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassRepositoryPort;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassServicePort;
import br.com.grimoire.hexagonalschool.infra.adapters.TeacherRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassService implements SchoolClassServicePort {

    private final SchoolClassRepositoryPort schoolClassRepositoryPort;
    private final TeacherRepository teacherRepositoryPort;

    @Override
    public List<ShowSchoolClassDTO> findAll() {
        return schoolClassRepositoryPort.findAll()
                .stream()
                .map(schoolClass -> new ShowSchoolClassDTO(schoolClass))
                .toList();
    }

    @Override
    public ShowSchoolClassDTO findById(Long idSchoolClass) {
        SchoolClass schoolClassDB = schoolClassRepositoryPort.findById(idSchoolClass);
        return new ShowSchoolClassDTO(schoolClassDB);
    }

    @Override
    public ShowSchoolClassDTO save(RegisterSchoolClassDTO registerSchoolClassDTO) {

        Teacher teacherDB = teacherRepositoryPort.findById(registerSchoolClassDTO.getIdTeacher());
        SchoolClass schoolToSave = registerSchoolClassDTO.toSchoolClass(teacherDB);

        SchoolClass schoolClassDB = schoolClassRepositoryPort.save(schoolToSave);
        return new ShowSchoolClassDTO(schoolClassDB);
    }

    @Override
    public void update(Long idSchoolClass, RegisterSchoolClassDTO registerSchoolClassDTO) {

        Teacher teacherDB = teacherRepositoryPort.findById(registerSchoolClassDTO.getIdTeacher());

        schoolClassRepositoryPort.update(idSchoolClass, registerSchoolClassDTO.toSchoolClass(teacherDB));
    }

    @Override
    public void deleteById(Long idSchoolClass) {
        schoolClassRepositoryPort.deleteById(idSchoolClass);
    }

}
