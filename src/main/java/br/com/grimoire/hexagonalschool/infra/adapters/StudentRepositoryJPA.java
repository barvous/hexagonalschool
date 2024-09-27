package br.com.grimoire.hexagonalschool.infra.adapters;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grimoire.hexagonalschool.infra.entities.StudentEntity;

public interface StudentRepositoryJPA extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByCpf(String cpf);
}
