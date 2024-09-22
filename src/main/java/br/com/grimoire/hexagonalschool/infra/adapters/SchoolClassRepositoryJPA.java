package br.com.grimoire.hexagonalschool.infra.adapters;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grimoire.hexagonalschool.infra.entities.SchoolClassEntity;

public interface SchoolClassRepositoryJPA extends JpaRepository<SchoolClassEntity, Long> {

    Optional<SchoolClassEntity> findByCpf(String cpf);
}
