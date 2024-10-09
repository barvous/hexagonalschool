package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;

public interface SchoolClassRepositoryPort {
    
    List<SchoolClass> findAll();

    SchoolClass findById(Long idSchoolClass);

    SchoolClass save(SchoolClass schoolClass);

    void update(Long idSchoolClass, SchoolClass schoolClass);

    void delete(Long idSchoolClass);
}
