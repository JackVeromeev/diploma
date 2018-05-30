package by.veromeev.diploma.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class ApplicationStatusController {

    @Autowired
    private ApplicationStatus applicationStatus;

    @ModelAttribute
    public void addMaintenanceStatus(Model model) {
        model.addAttribute("appStatus", applicationStatus);
    }
}
