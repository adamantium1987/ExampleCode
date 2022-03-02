package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Schema(description = "User object")
@Entity
@Table(name="users")
public class User {

    @JsonProperty(value="userId", required=true)    @Schema(description = "Unique identifier of the model.",example = "1", required = true)
    private Long userId;

    @JsonProperty(value="name", required=true)@Schema(description = "First and Last name of user",example = "John Doe, Jane Doe", required = true)
    @NotBlank
    private String name;

    @JsonProperty(value="user_type", required=true)@Schema(description = "User type of the user.",example = "Employee or Customer", required = true)
    @NotBlank
    private String userType;

    @JsonProperty(value="user_email", required=true)@Schema(description = "User email address of the user.",example = "john.doe@email.com", required = true)
    @NotBlank
    private String user_email;

    @JsonProperty(value="user_status", required=true)@Schema(description = "User status of the user.",example = "Active or Inactive", required = true)
    @NotBlank
    private String user_status;

    public User() {
    }

    public User(Long userId, String name, String userType, String user_email, String user_status) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.user_email = user_email;
        this.user_status = user_status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {        return name;    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String type) {
        this.userType = type;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
