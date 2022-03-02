package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employee extends User{
    @JsonProperty(value="user_role", required=true)@Schema(description = "Role of the user.",example = "Administrator, Manager, Employee", required = true)
    @NotBlank
    @Size(min = 0)
    private String user_status;

    enum Role {
        ADMINISTRATOR,
        MANAGER,
        EMPLOYEE
    }
    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }
}
