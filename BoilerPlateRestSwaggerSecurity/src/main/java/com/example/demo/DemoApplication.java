package com.example.demo;

import com.example.demo.auth.UserService;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


/*    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_CUSTOMER"));
            userService.saveRole(new Role(null, "ROLE_EMPLOYEE"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMINISTRATOR"));
            userService.saveRole(new Role(null, "ROLE_ADMINISTRATOR_READONLY"));

            userService.saveUser(new User(null, "Administrator", "admin", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "AdministratorReadOnly", "adminro", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Manager", "manager", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Employee", "employee", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Customer", "customer", "1234", new ArrayList<>()));

            userService.addRoleToUser("customer", "ROLE_CUSTOMER");
            userService.addRoleToUser("employee", "ROLE_EMPLOYEE");
            userService.addRoleToUser("manager", "ROLE_MANAGER");
            userService.addRoleToUser("adminro", "ROLE_ADMINISTRATOR_READONLY");
            userService.addRoleToUser("admin", "ROLE_ADMINISTRATOR");
        };
    }*/
}
