package by.veromeev.diploma.core;

import lombok.Data;
import org.springframework.stereotype.Controller;

import static by.veromeev.diploma.core.ApplicationStatus.Status.DOWN;
import static by.veromeev.diploma.core.ApplicationStatus.Status.UP;

@Controller
@Data
public class ApplicationStatus {

    public enum Status {
        UP, GETTING_DOWN, DOWN_PROCESSING, DOWN
    }

    private Status status;

    public boolean isUp() {
        return status == UP;
    }

    public boolean isDown() {
        return status == DOWN;
    }

    public ApplicationStatus() {
        this.status = DOWN;
    }

}
