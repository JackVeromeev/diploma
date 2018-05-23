package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatWindow extends AbstractEntity {

    private static final long serialVersionUID = 14485663450357523L;

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 15, max = 18)
    private String SFOrganizationId;

    @NotBlank
    @Length(min = 15, max = 18)
    private String SFButtonsId;

    @NotBlank
    @Length(min = 15, max = 18)
    private String SFDeploymentId;


    @Transient
    private Long chatSessionsCount;

    @Transient
    private Long activeChatSessionsCount;

    public Boolean activeChatSessionsExist() {
        return activeChatSessionsCount > 0;
    }
}
