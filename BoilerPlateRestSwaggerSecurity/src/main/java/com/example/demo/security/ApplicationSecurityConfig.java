package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.TimeUnit;

import static com.example.demo.security.ApplicationUserRole.*;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // H2-Database Code
        // THIS IS NOT PRODUCTION CODE; THIS IS ONLY FOR DEMO PURPOSES!
        http.authorizeRequests().antMatchers("/console/**" , "/actuator/**").permitAll()//.hasRole(ADMINISTRATOR.name())
                .and().csrf().ignoringAntMatchers("/console/**").and().headers().frameOptions().sameOrigin();
        // End H2-Database Code

        // Swagger UI Code
        http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();
        http.csrf().ignoringAntMatchers("/swagger-ui/**").and().headers().frameOptions().sameOrigin();
        // End Swagger UI Code

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index" , "/css/*" , "/js/*").permitAll()
                .antMatchers("/api/v1/user").hasRole(ADMINISTRATOR.name())

                // No User Interface
                //.anyRequest().authenticated().and().httpBasic() .clearAuthentication(true).invalidateHttpSession(true);
                //User Interface
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/homepage" , true)
                .passwordParameter("password")//this is the default time but wanted to add this for future proofing in case I wanted to change later
                .usernameParameter("username")//this is the default time but wanted to add this for future proofing in case I wanted to change later
                .and().rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(14))//this is the default time but wanted to add this for future proofing in case I wanted to change later
                .rememberMeParameter("remember-me")//this is the default time but wanted to add this for future proofing in case I wanted to change later
                .key("SuperSecureString")
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID" , "remember-me")
                .logoutSuccessUrl("/login");
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}