package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatWindow extends AbstractEntity {

    private static final long serialVersionUID = 14485663450357523L;

    @ManyToOne
    private SFDeployment deployment;

    @ManyToOne
    private SFButtons buttons;

    @OneToMany()
    private Set<ChatSession> chatSessions;
}
