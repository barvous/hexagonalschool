package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;

public interface SchoolClassRepositoryPort {
    
    List<SchoolClass> findAll();

    SchoolClass findById(Long idSchoolClass);

    SchoolClass save(RegisterSchoolClassDTO schoolClassDTO);

    void update(Long idSchoolClass, RegisterSchoolClassDTO schoolClassDTO);

    void deleteById(Long idSchoolClass);
}
