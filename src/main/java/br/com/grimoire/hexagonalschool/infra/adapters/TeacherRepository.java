package br.com.grimoire.hexagonalschool.infra.adapters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import br.com.grimoire.hexagonalschool.domain.models.exception.InternalServerException;
import br.com.grimoire.hexagonalschool.domain.models.exception.NotFoundException;
import br.com.grimoire.hexagonalschool.domain.ports.TeacherRespositoryPort;
import br.com.grimoire.hexagonalschool.infra.entities.TeacherEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherRepository implements TeacherRespositoryPort {

    private final TeacherRepositoryJPA teacherRepositoryJPA;

    @Override
    public Teacher findById(Long idTeacher) {
        return teacherRepositoryJPA.findById(idTeacher)
                .orElseThrow(() -> new NotFoundException("Teacher not founded")).toTeacher();

    }

    @Override
    public Teacher findByCpf(String cpf) {
        return teacherRepositoryJPA.findByCpf(cpf).orElseThrow(() -> new NotFoundException("Teacher not founded"))
                .toTeacher();
    }

    @Override
    public Teacher save(Teacher teacher) {
        teacher.id = null;

        try {
            return teacherRepositoryJPA.save(new TeacherEntity(teacher)).toTeacher();
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to save teacher");
        }
    }

    @Override
    public void update(Long idTeacher, Teacher teacher) {

        Teacher teacherDB = findById(idTeacher);

        BeanUtils.copyProperties(teacher, teacherDB);

        try {
            teacherRepositoryJPA.save(new TeacherEntity(teacherDB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to update teacher with id " + idTeacher);
        }
    }

    @Override
    public void delete(Long idTeacher) {
        findById(idTeacher);

        try {
            teacherRepositoryJPA.deleteById(idTeacher);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to delete teacher with id " + idTeacher);
        }
    }

}
