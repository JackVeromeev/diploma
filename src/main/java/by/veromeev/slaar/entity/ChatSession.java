package by.veromeev.slaar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"chatWindow", "offlineRequest",
        "botChatSessionBlocks", "operatorChatSessionBlocks"})
@ToString(exclude = {"chatWindow", "offlineRequest",
        "botChatSessionBlocks", "operatorChatSessionBlocks"})
public class ChatSession extends AbstractChatSession {

    private static final long serialVersionUID = 8914336319596204870L;

    private String SFSessionId;

    private String chasitorId;

    private SessionState sessionState = SessionState.CHAT_SYSTEM;

    private String jSessionId;

    private LocalDateTime lastActivityAt;

    @NotBlank
    private String visitorName;

    @ManyToOne(targetEntity = ChatWindow.class)
    private ChatWindow chatWindow;

    @OneToOne(mappedBy = "chatSession")
    private OfflineRequest offlineRequest;

    @OneToMany(mappedBy = "chatSession")
    private Set<BotChatSessionBlock> botChatSessionBlocks;

    @OneToMany(mappedBy = "chatSession")
    private Set<OperatorChatSessionBlock> operatorChatSessionBlocks;

    public enum SessionState {

        CHAT_SYSTEM, CHAT_OPERATOR, CLOSED_BY_VISITOR, CLOSED_TIMEOUT;

        public Boolean isActive() {
            return this == CHAT_SYSTEM || this == CHAT_OPERATOR;
        }

    }

    public Boolean isActive() {
        return sessionState.isActive();
    }
}
