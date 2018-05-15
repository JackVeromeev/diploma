package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Collects information about question and answer (or another action)
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BotChatMessagePair extends AbstractEntity {

    private static final long serialVersionUID = -7305377548747160631L;

    private String question;

    private String mostSimillarQuestion;

    private String desision;

    private String answer;

    @OneToMany
    private Set<Attachment> attachments;
}
