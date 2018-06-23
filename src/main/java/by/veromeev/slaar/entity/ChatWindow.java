package by.veromeev.slaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"chatSessions"})
public class ChatWindow extends AbstractEntity {

    private static final long serialVersionUID = 14485663450357523L;

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 15, max = 18)
    private String SFOrganizationId;

    @NotBlank
    @Length(min = 15, max = 18)
    private String SFButtonsId;

    @NotBlank
    @Length(min = 15, max = 18)
    private String SFDeploymentId;

    @OneToMany(mappedBy = "chatWindow", fetch = FetchType.EAGER)
    private Set<ChatSession> chatSessions = new HashSet<>();

    public Long getChatSessionsCount() {
        return (long) chatSessions.size();
    }

    public Long getActiveChatSessionsCount() {
        return chatSessions.stream()
                .filter(ChatSession::isActive)
                .count();
    }

    public Boolean activeChatSessionsExist() {
        return getActiveChatSessionsCount() > 0;
    }
}
