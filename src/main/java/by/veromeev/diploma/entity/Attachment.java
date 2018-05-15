package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attachment extends AbstractEntity {

    private static final long serialVersionUID = -9163720361327691909L;

    private String filePath;

    @ManyToOne
    private OperatorChatMessage message;

    @ManyToOne
    private BotChatMessagePair botChatMessagePair;

}
