package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;

public interface SchoolClassServicePort {

    List<SchoolClass> findAll();

    SchoolClass findById(Long idSchoolClass);

    SchoolClass save(SchoolClass schoolClass);

    void update(Long idsSchoolClass, SchoolClass schoolClass);

    void delete(Long idSchoolClass);
}
