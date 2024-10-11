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

import br.com.grimoire.hexagonalschool.application.adapters.TeacherService;
import br.com.grimoire.hexagonalschool.domain.dto.RegisterTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.dto.ShowTeacherDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<ShowTeacherDTO>> findAll() {

        List<ShowTeacherDTO> listTeacher = teacherService.findAll();

        return ResponseEntity.ok().body(listTeacher);
    }

    @GetMapping(path = "/{id_teacher}")
    public ResponseEntity<ShowTeacherDTO> findById(@PathVariable("id_teacher") Long idTeacher) {

        ShowTeacherDTO teacherDTO = teacherService.findById(idTeacher);

        return ResponseEntity.ok().body(teacherDTO);
    }

    @PostMapping
    public ResponseEntity<ShowTeacherDTO> saveTeacher(@RequestBody RegisterTeacherDTO registerTeacherDTO) {

        ShowTeacherDTO showTeacherDTO = teacherService.save(registerTeacherDTO);

        return ResponseEntity.ok().body(showTeacherDTO);
    }

    @PutMapping(path = "/{id_teacher}")
    public ResponseEntity<Void> updateTeacher(@PathVariable("id_teacher") Long idTeacher,
            @RequestBody RegisterTeacherDTO registerTeacherDTO) {

        teacherService.update(idTeacher, registerTeacherDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id_teacher}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id_teacher") Long idTeacher) {

        teacherService.delete(idTeacher);

        return ResponseEntity.ok().build();
    }
}
