package by.veromeev.slaar.core;

import lombok.Getter;
import org.springframework.stereotype.Component;

import static by.veromeev.slaar.core.ApplicationStatus.Status.*;

@Component
public class ApplicationStatus {

    public enum Status {
        UP, GETTING_DOWN, DOWN_PROCESSING, DOWN
    }

    public ApplicationStatus() {
        this.status = DOWN;
    }

    @Getter
    private Status status;

    public boolean isUp() {
        return status == UP;
    }

    public boolean isDown() {
        return status == DOWN;
    }

    public boolean isGettingDown() {
        return this.status == GETTING_DOWN;
    }

    public boolean isProcessing() {
        return this.status == DOWN_PROCESSING;
    }




}
