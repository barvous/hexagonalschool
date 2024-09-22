package br.com.grimoire.hexagonalschool.infra.adapters;

import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
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
    public SchoolClass findByCpf(String cpf) {
        SchoolClassEntity schoolClassEntity = schoolClassRepositoryJPA.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("School class not founded"));

        return schoolClassEntity.toSchoolClass();
    }

    @Override
    public SchoolClass save(SchoolClass schoolClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Long idSchoolClass, SchoolClass schoolClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long idSchoolClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
