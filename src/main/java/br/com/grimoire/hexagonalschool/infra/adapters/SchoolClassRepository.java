package br.com.grimoire.hexagonalschool.infra.adapters;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassRepositoryPort;
import br.com.grimoire.hexagonalschool.infra.entities.SchoolClassEntity;
import br.com.grimoire.hexagonalschool.infra.exception.InternalServerException;
import br.com.grimoire.hexagonalschool.infra.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassRepository implements SchoolClassRepositoryPort {

    private final SchoolClassRepositoryJPA schoolClassRepositoryJPA;

    @Override
    public List<SchoolClass> findAll() {
        return schoolClassRepositoryJPA.findAll()
                .stream()
                .map(eachClass -> eachClass.toSchoolClass())
                .toList();
    }

    @Override
    public SchoolClass findById(Long idSchoolClass) {
        SchoolClassEntity schoolClassEntity = schoolClassRepositoryJPA.findById(idSchoolClass)
                .orElseThrow(() -> new NotFoundException("School class not founded"));

        return schoolClassEntity.toSchoolClass();
    }

    private SchoolClassEntity findEntityById(Long idSchoolClass) {
        return schoolClassRepositoryJPA.findById(idSchoolClass)
                .orElseThrow(() -> new NotFoundException("School class not founded"));
    }

    @Override
    public SchoolClass save(SchoolClass schoolClass) {

        SchoolClassEntity schoolClassEntity = new SchoolClassEntity(schoolClass);

        try {
            schoolClassEntity = schoolClassRepositoryJPA.save(schoolClassEntity);
            return schoolClassEntity.toSchoolClass();

        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to save the school class");
        }

    }

    @Override
    public void update(Long idSchoolClass, SchoolClass schoolClass) {

        SchoolClass schoolClassDB = findById(idSchoolClass);

        BeanUtils.copyProperties(schoolClass, schoolClassDB, "id");

        try {

            SchoolClassEntity schoolClassEntity = new SchoolClassEntity(schoolClassDB);
            schoolClassRepositoryJPA.save(schoolClassEntity);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to update school class with id " + idSchoolClass);
        }

    }

    @Override
    public void deleteById(Long idSchoolClass) {

        SchoolClassEntity schoolClassEntity = findEntityById(idSchoolClass);

        try {
            schoolClassRepositoryJPA.delete(schoolClassEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to delete school class with id" + idSchoolClass);
        }

    }

}
