package br.com.grimoire.hexagonalschool.domain.ports;

import java.util.List;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowSchoolClassDTO;

public interface SchoolClassServicePort {

    List<ShowSchoolClassDTO> findAll();

    ShowSchoolClassDTO findById(Long idSchoolClass);

    ShowSchoolClassDTO save(RegisterSchoolClassDTO registerSchoolClassDTO);

    void update(Long idsSchoolClass, RegisterSchoolClassDTO registerSchoolClassDTO);

    void deleteById(Long idSchoolClass);
}
