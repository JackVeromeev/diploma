package by.veromeev.slaar.admin.configuration;

import by.veromeev.slaar.dao.AdminDAO;
import by.veromeev.slaar.entity.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**", "/res/*", "/").authenticated()
                .antMatchers("/chat/*", "/login").permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and().csrf().disable();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    ApplicationRunner insertDefaultAdminCredentials(AdminDAO dao, PasswordEncoder passwordEncoder) {
        return args -> {
            System.out.println("runner started");
            if (dao.count() == 0) {
                System.out.println("runner inserts new Admin");
                dao.save(new AdminDetails(
                        "admin",
                        passwordEncoder.encode("admin")
                ));
                System.out.println("inserted");
            }
        };
    }
}
