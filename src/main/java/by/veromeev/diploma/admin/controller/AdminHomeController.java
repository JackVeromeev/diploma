package by.veromeev.diploma.admin.controller;

import by.veromeev.diploma.core.ApplicationStatusController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController extends ApplicationStatusController {

    @GetMapping(path = {"/", "/admin/"})
    public String admin() {
        return "admin";
    }

}
