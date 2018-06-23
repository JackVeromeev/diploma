package by.veromeev.slaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractChatSession extends AbstractEntity {

    private static final long serialVersionUID = 5156193216546006995L;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

}
