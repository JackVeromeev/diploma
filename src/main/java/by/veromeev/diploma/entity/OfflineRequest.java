package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OfflineRequest extends AbstractEntity {

    private static final long serialVersionUID = 5725789580921672264L;

    @OneToOne
    private ChatSession chatSession;

    private String message;
}
