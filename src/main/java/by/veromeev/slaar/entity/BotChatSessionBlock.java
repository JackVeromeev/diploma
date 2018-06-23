package by.veromeev.slaar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.TreeSet;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(
        exclude = {"chatSession", "currentKnowledgeNode", "botChatMessagePairs"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"chatSession", "currentKnowledgeNode", "botChatMessagePairs"})
public class BotChatSessionBlock extends AbstractChatSession {

    private static final long serialVersionUID = -4350398335647442215L;

    @ManyToOne(targetEntity = ChatSession.class)
    private ChatSession chatSession;

    @ManyToOne(targetEntity = KnowledgeNode.class)
    private KnowledgeNode currentKnowledgeNode;

    @OneToMany(mappedBy = "sessionBlock")
    private Set<BotChatMessagePair> botChatMessagePairs = new TreeSet<>();

}
