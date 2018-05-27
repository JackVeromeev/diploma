package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class OperatorChatMessage extends AbstractEntity implements Comparable<OperatorChatMessage> {

    private static final long serialVersionUID = -3541746821607567750L;

    private LocalDateTime createdDateTime;

    private String sender;

    private String message;

    @ManyToOne
    private OperatorChatSessionBlock sessionBlock;

    @Override
    public int compareTo(OperatorChatMessage o) {
        return this.getCreatedDateTime().compareTo(o.getCreatedDateTime());
    }
}
