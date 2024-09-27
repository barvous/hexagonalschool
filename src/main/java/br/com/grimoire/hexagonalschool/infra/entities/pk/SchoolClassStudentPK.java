package br.com.grimoire.hexagonalschool.infra.entities.pk;

import br.com.grimoire.hexagonalschool.infra.entities.SchoolClassEntity;
import br.com.grimoire.hexagonalschool.infra.entities.StudentEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClassStudentPK {

    @ManyToOne
    @JoinColumn(name = "ID_SCHOOL_CLASS")
    private SchoolClassEntity schoolClassEntity;

    @ManyToOne
    @JoinColumn(name = "ID_STUDENT")
    private StudentEntity studentEntity;
}
