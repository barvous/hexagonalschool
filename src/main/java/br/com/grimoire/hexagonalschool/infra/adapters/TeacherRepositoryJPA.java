package br.com.grimoire.hexagonalschool.infra.adapters;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grimoire.hexagonalschool.infra.entities.TeacherEntity;

public interface TeacherRepositoryJPA extends JpaRepository<TeacherEntity, Long> {

    Optional<TeacherEntity> findByCpf(String cpf);
}
