package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "User object")

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @JsonProperty(value="userId", required=true)    @Schema(description = "Unique identifier of the model.",example = "1", required = true)
    private Long userId;

    @JsonProperty(value="name", required=true)@Schema(description = "First name of user",example = "John, Jane", required = true)
    @NotBlank
    private String firstName;

    @JsonProperty(value="name", required=true)@Schema(description = "First name of user",example = "Smith , ", required = true)
    @NotBlank
    private String lastName;

    @JsonProperty(value="name", required=true)@Schema(description = "user name of user",example = "JohnSmith", required = true)
    @NotBlank
    private String userName;

    @JsonProperty(value="password", required=true)@Schema(description = "Password For User",example = "JohnSmith", required = true)
    @NotBlank
    private String password;

    @JsonProperty(value="user_type", required=true)@Schema(description = "User type of the user.",example = "Employee or Customer", required = true)
    @NotBlank
    private String userType;

    @JsonProperty(value="user_email", required=true)@Schema(description = "User email address of the user.",example = "john.doe@email.com", required = true)
    @NotBlank
    private String email;

    @JsonProperty(value="user_status", required=true)@Schema(description = "User status of the user.",example = "Active or Inactive", required = true)
    @NotBlank
    private String user_status;

    private String role;

}
