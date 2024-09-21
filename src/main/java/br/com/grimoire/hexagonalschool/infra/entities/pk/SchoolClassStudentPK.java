package br.com.grimoire.hexagonalschool.infra.entities.pk;

import br.com.grimoire.hexagonalschool.infra.entities.SchoolClassEntity;
import br.com.grimoire.hexagonalschool.infra.entities.StudentEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SchoolClassStudentPK {

    @ManyToOne
    @JoinColumn(name = "ID_SCHOOL_CLASS")
    private SchoolClassEntity schoolClassEntity;

    @ManyToOne
    @JoinColumn(name = "ID_STUDENT")
    private StudentEntity studentEntity;
}
