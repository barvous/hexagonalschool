package br.com.grimoire.hexagonalschool.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grimoire.hexagonalschool.domain.dto.RegisterSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowSchoolClassDTO;
import br.com.grimoire.hexagonalschool.domain.ports.SchoolClassServicePort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/school-classes")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassServicePort schoolClassServicePort;

    @GetMapping
    public ResponseEntity<List<ShowSchoolClassDTO>> findAllSchoolClasses() {

        List<ShowSchoolClassDTO> schoolClassListDTO = schoolClassServicePort.findAll();

        return ResponseEntity.ok().body(schoolClassListDTO);

    }

    @GetMapping(path = "/{id_class}")
    public ResponseEntity<ShowSchoolClassDTO> findSchoolClassesById(
            @PathVariable("id_class") Long idSchoolClass) {

        ShowSchoolClassDTO schoolClassDTO = schoolClassServicePort.findById(idSchoolClass);

        return ResponseEntity.ok().body(schoolClassDTO);

    }

    @PostMapping
    public ResponseEntity<ShowSchoolClassDTO> saveSchoolClass(
            @RequestBody RegisterSchoolClassDTO registerSchoolClassDTO) {

        ShowSchoolClassDTO showSchoolClassDTO = schoolClassServicePort.save(registerSchoolClassDTO);

        return ResponseEntity.ok().body(showSchoolClassDTO);

    }

    @PutMapping(path = "/{id_class}")
    public ResponseEntity<Void> updateSchoolClass(@PathVariable("id_class") Long idSchoolClass,
            @RequestBody RegisterSchoolClassDTO registerSchoolClassDTO) {

        schoolClassServicePort.update(idSchoolClass, registerSchoolClassDTO);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping(path = "/{id_class}")
    public ResponseEntity<Void> deleteSchoolClassById(@PathVariable("id_class") Long idSchoolClass) {

        schoolClassServicePort.deleteById(idSchoolClass);

        return ResponseEntity.ok().build();

    }
}
