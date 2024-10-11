package br.com.grimoire.hexagonalschool.application.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.models.SchoolClass;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassRepositoryPort;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassServicePort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassService implements SchoolClassServicePort {

    private final SchoolClassRepositoryPort schoolClassRepositoryPort;

    @Override
    public List<ShowSchoolClassDTO> findAll() {
        return schoolClassRepositoryPort.findAll()
                .stream()
                .map(schoolClass -> new ShowSchoolClassDTO(schoolClass))
                .toList();
    }

    @Override
    public ShowSchoolClassDTO findById(Long idSchoolClass) {
        SchoolClass schoolClassDB = schoolClassRepositoryPort.findById(idSchoolClass);
        return new ShowSchoolClassDTO(schoolClassDB);
    }

    @Override
    public ShowSchoolClassDTO save(RegisterSchoolClassDTO registerSchoolClassDTO) {
        SchoolClass schoolClassDB = schoolClassRepositoryPort.save(registerSchoolClassDTO);
        return new ShowSchoolClassDTO(schoolClassDB);
    }

    @Override
    public void update(Long idsSchoolClass, RegisterSchoolClassDTO registerSchoolClassDTO) {
        schoolClassRepositoryPort.update(idsSchoolClass, registerSchoolClassDTO);
    }

    @Override
    public void delete(Long idSchoolClass) {
        schoolClassRepositoryPort.delete(idSchoolClass);
    }

}
