package by.veromeev.slaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class AdminDetails extends AbstractEntity {

    private static final long serialVersionUID = 2190921285470659616L;

    private String username;

    private String password;

}
