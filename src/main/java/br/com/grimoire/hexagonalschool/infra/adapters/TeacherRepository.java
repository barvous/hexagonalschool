package br.com.grimoire.hexagonalschool.infra.adapters;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import br.com.grimoire.hexagonalschool.domain.ports.TeacherRespositoryPort;
import br.com.grimoire.hexagonalschool.infra.entities.TeacherEntity;
import br.com.grimoire.hexagonalschool.infra.exception.InternalServerException;
import br.com.grimoire.hexagonalschool.infra.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherRepository implements TeacherRespositoryPort {

    private final TeacherRepositoryJPA teacherRepositoryJPA;

    @Override
    public List<Teacher> findAll() {
        return teacherRepositoryJPA.findAll().stream().map(TeacherEntity::toTeacher).toList();
    }

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

        BeanUtils.copyProperties(teacher, teacherDB, "id");

        try {
            teacherRepositoryJPA.save(new TeacherEntity(teacherDB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to update teacher with id " + idTeacher);
        }
    }

    @Override
    public void deleteById(Long idTeacher) {
        findById(idTeacher);

        try {
            teacherRepositoryJPA.deleteById(idTeacher);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to delete teacher with id " + idTeacher);
        }
    }

}
