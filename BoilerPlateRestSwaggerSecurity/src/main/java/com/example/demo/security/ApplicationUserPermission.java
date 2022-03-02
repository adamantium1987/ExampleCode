package com.example.demo.security;

public enum ApplicationUserPermission {
    ADMINISTRATOR_READ("administrator:read"),
    ADMINISTRATOR_WRITE("administrator:write"),
    MANAGER_READ("manager:read"),
    MANAGER_WRITE("manager:write"),
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write");

    private final String permission;
    ApplicationUserPermission(String permission){
        this.permission=permission;
    }

    public String getPermission() {
        return permission;
    }
}
