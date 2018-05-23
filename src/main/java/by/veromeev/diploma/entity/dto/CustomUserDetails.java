package by.veromeev.diploma.entity.dto;

import by.veromeev.diploma.entity.AdminDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<GrantedAuthority> roles = new ArrayList<>(1);

    public CustomUserDetails(AdminDetails adminDetails) {
        this.username = adminDetails.getUsername();
        this.password = adminDetails.getPassword();
        this.roles.add(() -> "ADMIN");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
