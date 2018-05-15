package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KnowledgeNode extends AbstractEntity {

    private static final long serialVersionUID = -2297080035478660876L;

    @ManyToOne
    private KnowledgeNode parentNode;

    @OneToMany
    private Set<KnowledgeNode> childNodes;

    private String question;

    private String answer;

}
