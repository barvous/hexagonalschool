package br.com.grimoire.hexagonalschool.domain.ports;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;

public interface SchoolClassRepositoryPort {
    
    SchoolClass findById(Long idSchoolClass);

    SchoolClass findByCpf(String cpf);

    SchoolClass save(SchoolClass schoolClass);

    void update(Long idSchoolClass, SchoolClass schoolClass);

    void delete(Long idSchoolClass);
}
