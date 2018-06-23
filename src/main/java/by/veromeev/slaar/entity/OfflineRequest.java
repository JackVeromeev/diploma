package by.veromeev.slaar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"chatSession"})
@ToString(exclude = {"chatSession"})
public class OfflineRequest extends AbstractEntity {

    private static final long serialVersionUID = 5725789580921672264L;

    @OneToOne
    private ChatSession chatSession;

    @NotBlank
    private String message;

    @Email
    private String email;


}
