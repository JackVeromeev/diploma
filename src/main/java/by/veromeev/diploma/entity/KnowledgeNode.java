package by.veromeev.diploma.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"parentNode", "knowledgeNodes", "tfIdf"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"parentNode", "knowledgeNodes", "tfIdf"})
public class KnowledgeNode extends AbstractEntity {

    private static final long serialVersionUID = -2297080035478660876L;

    @ManyToOne(targetEntity = KnowledgeNode.class)
    private KnowledgeNode parentNode = null;

    @SerializedName("children")
    @OneToMany(mappedBy = "parentNode", cascade = CascadeType.ALL)
    private Set<KnowledgeNode> knowledgeNodes = new HashSet<>();

    private String name;

    private String question;

    private String newQuestion = null;

    private String answer;

    private Boolean isActive = false;

    @SerializedName("special")
    private Boolean isSpecial = false;

    private Double[] tfIdf = new Double[0];

}
