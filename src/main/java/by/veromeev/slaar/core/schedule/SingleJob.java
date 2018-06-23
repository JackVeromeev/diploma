package by.veromeev.slaar.core.schedule;

import java.time.LocalDateTime;

public interface SingleJob extends Job {
    LocalDateTime getDateTime();
}
