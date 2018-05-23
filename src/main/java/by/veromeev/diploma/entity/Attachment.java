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
public class Attachment extends AbstractEntity {

    private static final long serialVersionUID = -9163720361327691909L;

    private String filePath;

    @ManyToOne(targetEntity = OperatorChatMessage.class)
    private OperatorChatMessage operatorChatMessage;

    @ManyToOne(targetEntity = BotChatMessagePair.class)
    private BotChatMessagePair botChatMessagePair;

    @ManyToOne(targetEntity = OfflineRequest.class)
    private OfflineRequest offlineRequest;

}
