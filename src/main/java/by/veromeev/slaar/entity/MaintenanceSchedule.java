package by.veromeev.slaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class MaintenanceSchedule extends AbstractEntity {

    @Nullable
    private LocalDateTime maintenanceStart;

    @Nullable
    private String cronValue;

}
