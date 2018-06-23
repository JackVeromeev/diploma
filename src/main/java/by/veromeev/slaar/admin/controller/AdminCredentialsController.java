package by.veromeev.slaar.admin.controller;

import by.veromeev.slaar.core.ApplicationStatusController;
import by.veromeev.slaar.dao.AdminDAO;
import by.veromeev.slaar.entity.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminCredentialsController extends ApplicationStatusController {

    private AdminDAO adminDAO;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminCredentialsController(AdminDAO adminDAO, PasswordEncoder passwordEncoder) {
        this.adminDAO = adminDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/credentials")
    public String credentials(Model model) {
        AdminDetails dbDetails = adminDAO.findAll().iterator().next();
        model.addAttribute("oldUsername", dbDetails.getUsername());
        return "admin.credentials";
    }

    @PostMapping("/admin/credentials")
    public String updateCredentials(AdminDetails adminDetails, Model model) {
        AdminDetails dbDetails = adminDAO.findAll().iterator().next();
        System.out.println("DbaseDetails" + dbDetails.toString());
        System.out.println("AdminDetails" + adminDetails.toString());
        if (adminDetails.getUsername() != null && !"".equals(adminDetails.getUsername())) {
            dbDetails.setUsername(adminDetails.getUsername());
        }
        if (adminDetails.getPassword() != null && !"".equals(adminDetails.getPassword())) {
            dbDetails.setPassword(passwordEncoder.encode(adminDetails.getPassword()));
        }
        adminDAO.save(dbDetails);
        return credentials(model);
    }
}
