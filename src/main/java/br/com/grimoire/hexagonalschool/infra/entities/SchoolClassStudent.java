package br.com.grimoire.hexagonalschool.infra.entities;

import br.com.grimoire.hexagonalschool.infra.entities.pk.SchoolClassStudentPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCHOOL_CLASS_STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClassStudent {

    @EmbeddedId
    private SchoolClassStudentPK schoolClassStudentPK = new SchoolClassStudentPK();
}
