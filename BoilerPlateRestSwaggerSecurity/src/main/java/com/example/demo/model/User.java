package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String userType;
    private String email;
    private String user_status;
    private String role;

}
