package by.veromeev.diploma.admin.configuration;

import by.veromeev.diploma.dao.AdminDAO;
import by.veromeev.diploma.entity.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/admin/home").permitAll().anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                .and().csrf().disable();
    }

    @Bean(name = "passwordEncoder")
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    ApplicationRunner runner(AdminDAO dao, PasswordEncoder passwordEncoder) {
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
