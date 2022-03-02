package com.example.demo.security;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@SecurityScheme(name="BoilerPlateAPI", scheme="basic", type= SecuritySchemeType.HTTP, in= SecuritySchemeIn.HEADER)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles(ADMINISTRATOR.name())
                .build();
        UserDetails managerUser = User.builder()
                .username("manager")
                .password(passwordEncoder.encode("123"))
                .roles(MANAGER.name())
                .build();
        UserDetails employeeUser = User.builder()
                .username("employee")
                .password(passwordEncoder.encode("123"))
                .roles(EMPLOYEE.name())
                .build();
        UserDetails customerUser = User.builder()
                .username("customer")
                .password(passwordEncoder.encode("123"))
                .roles(CUSTOMER.name())
                .build();
        return new InMemoryUserDetailsManager(adminUser, managerUser, employeeUser, customerUser);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // H2-Database Code
        // THIS IS NOT PRODUCTION CODE; THIS IS ONLY FOR DEMO PURPOSES!
        http.authorizeRequests().antMatchers("/console/**").permitAll();
        http.csrf().ignoringAntMatchers("/console/**").and().headers().frameOptions().sameOrigin();
        // End H2-Database Code

        http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll().anyRequest().authenticated().and().httpBasic();
        http.csrf().disable();
    }
}