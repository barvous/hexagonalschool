package br.com.grimoire.hexagonalschool.infra.adapters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.models.Student;
import br.com.grimoire.hexagonalschool.domain.models.exception.InternalServerException;
import br.com.grimoire.hexagonalschool.domain.models.exception.NotFoundException;
import br.com.grimoire.hexagonalschool.domain.ports.StudentRepositoryPort;
import br.com.grimoire.hexagonalschool.infra.entities.StudentEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentRepository implements StudentRepositoryPort {

    private final StudentRepositoryJPA studentRepositoryJPA;

    @Override
    public List<Student> findAll() {
        List<StudentEntity> studentEntityList = studentRepositoryJPA.findAll();

        return studentEntityList.isEmpty() ? new ArrayList<>()
                : studentEntityList.stream().map(StudentEntity::toStudent).toList();
    }

    @Override
    public Student findById(Long idStudent) {
        return studentRepositoryJPA.findById(idStudent).orElseThrow(() -> new NotFoundException("Student not founded"))
                .toStudent();
    }

    @Override
    public Student findByCpf(String cpf) {
        return studentRepositoryJPA.findByCpf(cpf).orElseThrow(() -> new NotFoundException("Student not founded"))
                .toStudent();
    }

    @Override
    public Student save(Student student) {
        student.setId(null);

        try {
            return studentRepositoryJPA.save(new StudentEntity(student)).toStudent();
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to save student");
        }
    }

    @Override
    public void update(Long idStudent, Student student) {
        Student studentDB = findById(idStudent);

        BeanUtils.copyProperties(student, studentDB, "id");

        try {
            studentRepositoryJPA.save(new StudentEntity(studentDB));
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to update student");
        }
    }

    @Override
    public void delete(Long idStudent) {
        findById(idStudent);

        try {
            studentRepositoryJPA.deleteById(idStudent);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to delete student");
        }
    }

}
