package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class KnowledgeNode extends AbstractEntity {

    private static final long serialVersionUID = -2297080035478660876L;

    @ManyToOne
    private KnowledgeNode parentNode;

    private String question;

    private String answer;

    private Boolean isActive;

}
