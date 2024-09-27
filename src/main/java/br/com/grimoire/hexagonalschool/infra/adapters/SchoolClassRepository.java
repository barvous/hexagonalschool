package br.com.grimoire.hexagonalschool.infra.adapters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import br.com.grimoire.hexagonalschool.domain.models.exception.InternalServerException;
import br.com.grimoire.hexagonalschool.domain.models.exception.NotFoundException;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassRepositoryPort;
import br.com.grimoire.hexagonalschool.infra.entities.SchoolClassEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassRepository implements SchoolClassRepositoryPort {

    private final SchoolClassRepositoryJPA schoolClassRepositoryJPA;

    @Override
    public SchoolClass findById(Long idSchoolClass) {
        SchoolClassEntity schoolClassEntity = schoolClassRepositoryJPA.findById(idSchoolClass)
                .orElseThrow(() -> new NotFoundException("School class not founded"));

        return schoolClassEntity.toSchoolClass();
    }

    @Override
    public SchoolClass save(SchoolClass schoolClass) {
        // TODO: Create a DTO to register an school, so that i dont have do to this "set
        // null"

        schoolClass.setId(null);
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

        BeanUtils.copyProperties(schoolClass, schoolClassDB);

        try {

            SchoolClassEntity schoolClassEntity = new SchoolClassEntity(schoolClassDB);
            schoolClassRepositoryJPA.save(schoolClassEntity);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to update school class with id " + idSchoolClass);
        }

    }

    @Override
    public void delete(Long idSchoolClass) {

        findById(idSchoolClass); // Just to make shure that this object exists in DB

        try {
            schoolClassRepositoryJPA.deleteById(idSchoolClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerException("Failed to delete school class with id" + idSchoolClass);
        }

    }

}
