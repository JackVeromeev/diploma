package by.veromeev.slaar.admin.controller;

import by.veromeev.slaar.core.ApplicationStatusController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController extends ApplicationStatusController {

    @GetMapping(path = {"/", "/admin/"})
    public String admin() {
        return "admin";
    }

}
