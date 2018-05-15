package by.veromeev.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SFDeployment extends AbstractEntity {

    private static final long serialVersionUID = 7909726184702934798L;

    private String name;

    private String description;

    private String SalesforceId;

    @OneToMany
    private Set<ChatWindow> chatWindows;

}
