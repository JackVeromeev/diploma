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
public class OperatorChatSessionBlock extends AbstractChatSession {

    private static final long serialVersionUID = -7298601986955734964L;

    @ManyToOne
    private ChatSession chatSession;

}
