package by.veromeev.diploma.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"knowledgeNode",
        "operatorChatMessage", "botChatMessagePair", "offlineRequest"})
@EqualsAndHashCode(callSuper = true, exclude = {"knowledgeNode",
        "operatorChatMessage", "botChatMessagePair", "offlineRequest"})
public class Attachment extends AbstractEntity {

    private static final long serialVersionUID = -9163720361327691909L;

    private String fileName;

    private byte[] fileData;

    private String fileType;

    @ManyToOne(targetEntity = KnowledgeNode.class)
    @Nullable
    private KnowledgeNode knowledgeNode;

    @ManyToOne(targetEntity = OperatorChatMessage.class)
    @Nullable
    private OperatorChatMessage operatorChatMessage;

    @ManyToOne(targetEntity = BotChatMessagePair.class)
    @Nullable
    private BotChatMessagePair botChatMessagePair;

    @ManyToOne(targetEntity = OfflineRequest.class)
    @Nullable
    private OfflineRequest offlineRequest;

}
