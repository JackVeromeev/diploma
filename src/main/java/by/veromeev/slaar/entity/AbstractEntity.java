package by.veromeev.slaar.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 550296239266736880L;

    @Id
    @GeneratedValue
    private Long id;

}

