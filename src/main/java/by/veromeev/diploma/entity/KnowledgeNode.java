package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class KnowledgeNode extends AbstractEntity {

    private static final long serialVersionUID = -2297080035478660876L;

    @ManyToOne(targetEntity = KnowledgeNode.class)
    private KnowledgeNode parentNode;

    @OneToMany(mappedBy = "parentNode")
    private Set<KnowledgeNode> knowledgeNodes = new HashSet<>();

    private String question;

    private String answer;

    private Boolean isActive;

    private Boolean isSpecial;

    private Double[] tfIdf;

}
