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

import br.com.grimoire.hexagonalschool.domain.dto.RegisterStudentDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowStudentDTO;
import br.com.grimoire.hexagonalschool.domain.ports.StudentServicePort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServicePort studentServicePort;

    @GetMapping
    public ResponseEntity<List<ShowStudentDTO>> findAll() {

        List<ShowStudentDTO> showStudentDTOList = studentServicePort.findAll();

        return ResponseEntity.ok().body(showStudentDTOList);
    }

    @GetMapping(path = "/{id_student}")
    public ResponseEntity<ShowStudentDTO> findById(@PathVariable("id_student") Long idStudent) {

        ShowStudentDTO showStudentDTO = studentServicePort.findById(idStudent);

        return ResponseEntity.ok().body(showStudentDTO);
    }

    @PostMapping
    public ResponseEntity<ShowStudentDTO> saveStudent(@RequestBody RegisterStudentDTO registerStudentDTO) {

        ShowStudentDTO showStudentDTO = studentServicePort.save(registerStudentDTO);

        return ResponseEntity.ok().body(showStudentDTO);
    }

    @PutMapping(path = "/{id_student}")
    public ResponseEntity<Void> updateStudent(@PathVariable("id_student") Long idStudent,
            @RequestBody RegisterStudentDTO registerStudentDTO) {

        studentServicePort.update(registerStudentDTO, idStudent);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id_student}")
    public ResponseEntity<Void> deleteById(@PathVariable("id_student") Long idStudent) {

        studentServicePort.deleteById(idStudent);

        return ResponseEntity.ok().build();
    }
}
