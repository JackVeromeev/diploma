package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperatorChatMessage extends AbstractEntity {

    private static final long serialVersionUID = -3541746821607567750L;

    private LocalDateTime getDateTime;

    private String sender;

    private String message;

    @OneToMany
    private Set<Attachment> attachments;

}
