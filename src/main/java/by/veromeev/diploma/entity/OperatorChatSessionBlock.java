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
public class OperatorChatSessionBlock extends AbstractChatSession {

    private static final long serialVersionUID = -7298601986955734964L;

    @ManyToOne
    private ChatSession chatSession;

    @OneToMany
    private Set<OperatorChatMessage> messages;

}
