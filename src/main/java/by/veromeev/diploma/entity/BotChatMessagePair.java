package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Collects information about question and answer (or another action)
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class BotChatMessagePair extends AbstractEntity implements Comparable<BotChatMessagePair> {

    private static final long serialVersionUID = -7305377548747160631L;

    private String question;

    private String mostSimillarQuestion;

    private String desision;

    private String answer;

    private LocalDateTime receiveDateTime;

    private LocalDateTime sendDateTime;

    @ManyToOne
    private BotChatSessionBlock sessionBlock;

    @OneToMany(mappedBy = "botChatMessagePair")
    private Set<Attachment> attachments = new HashSet<>();

    @Override
    public int compareTo(BotChatMessagePair comparable) {
        return this.getReceiveDateTime().compareTo(comparable.getReceiveDateTime());
    }
}
