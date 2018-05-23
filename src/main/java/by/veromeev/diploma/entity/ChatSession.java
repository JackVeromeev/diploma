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
public class ChatSession extends AbstractChatSession {

    private static final long serialVersionUID = 8914336319596204870L;

    private String SFSessionId;

    private String chasitorId;

    private Boolean isActive;

    @ManyToOne
    private ChatWindow chatWindow;

}
