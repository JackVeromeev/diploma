package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BotChatSessionBlock extends AbstractChatSession {

    private static final long serialVersionUID = -4350398335647442215L;

    @ManyToOne
    private ChatSession chatSession;

}
