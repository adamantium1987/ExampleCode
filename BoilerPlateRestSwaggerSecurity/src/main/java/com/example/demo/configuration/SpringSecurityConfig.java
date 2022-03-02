package com.example.demo.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@EnableWebSecurity
@SecurityScheme(name="BoilerPlateAPI", scheme="basic", type=SecuritySchemeType.HTTP, in=SecuritySchemeIn.HEADER)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{bcrypt}$2a$10$BagghBQvnxcVuhHyXc9g9.fM6s109FakmyF4tPAoOMRkjqKsg1xl.") //123
                .authorities("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/swagger-ui/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
        http.csrf().disable();
    }
}
