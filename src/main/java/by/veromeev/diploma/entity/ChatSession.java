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
public class ChatSession extends AbstractChatSession {

    private static final long serialVersionUID = 8914336319596204870L;

    private String SFSessionId;

    private String chasitorId;

    @ManyToOne
    private ChatWindow chatWindow;

}
