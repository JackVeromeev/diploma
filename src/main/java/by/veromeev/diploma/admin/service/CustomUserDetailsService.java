package by.veromeev.diploma.admin.service;

import by.veromeev.diploma.dao.AdminDAO;
import by.veromeev.diploma.entity.AdminDetails;
import by.veromeev.diploma.entity.dto.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private AdminDAO adminDAO;

    @Autowired
    public CustomUserDetailsService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminDetails adminDetails = adminDAO.findAdminDetailsByUsername(s);
        if (adminDetails == null) throw new UsernameNotFoundException(s);
        return new CustomUserDetails(adminDetails);
    }
}
