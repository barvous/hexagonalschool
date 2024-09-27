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

import br.com.grimoire.hexagonalschool.adapters.TeacherService;
import br.com.grimoire.hexagonalschool.domain.dto.RegisterTeacherDTO;
import br.com.grimoire.hexagonalschool.domain.models.Teacher;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll() {

        List<Teacher> listTeacher = teacherService.findAll();

        return ResponseEntity.ok().body(listTeacher);
    }

    @GetMapping(path = "/{id_teacher}")
    public ResponseEntity<Teacher> findById(@PathVariable("id_teacher") Long idTeacher) {

        Teacher teacherDB = teacherService.findById(idTeacher);

        return ResponseEntity.ok().body(teacherDB);
    }

    @PostMapping
    public ResponseEntity<Long> saveTeacher(@RequestBody RegisterTeacherDTO registerTeacherDTO) {

        Long idTeacher = teacherService.save(registerTeacherDTO).getId();

        return ResponseEntity.ok().body(idTeacher);
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
