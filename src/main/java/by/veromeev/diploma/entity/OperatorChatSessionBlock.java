package by.veromeev.diploma.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"chatSession"})
@ToString(exclude = {"chatSession"})
public class OperatorChatSessionBlock extends AbstractChatSession {

    private static final long serialVersionUID = -7298601986955734964L;

    @ManyToOne
    private ChatSession chatSession;

}
