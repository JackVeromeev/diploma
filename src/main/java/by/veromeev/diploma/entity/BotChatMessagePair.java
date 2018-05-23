package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Collects information about question and answer (or another action)
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class BotChatMessagePair extends AbstractEntity {

    private static final long serialVersionUID = -7305377548747160631L;

    private String question;

    private String mostSimillarQuestion;

    private String desision;

    private String answer;

    @ManyToOne
    private BotChatSessionBlock sessionBlock;
}
