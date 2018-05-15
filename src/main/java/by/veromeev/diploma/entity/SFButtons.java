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
public class SFButtons extends AbstractEntity {

    private static final long serialVersionUID = -5366314991461512657L;

    private String name;

    private String description;

    private String SalesforceId;

    @OneToMany
    private Set<ChatWindow> chatWindows;

}
