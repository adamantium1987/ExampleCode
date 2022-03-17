package com.example.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMINISTRATOR(Sets.newHashSet(ADMINISTRATOR_READ,ADMINISTRATOR_WRITE)),
    ADMINISTRATOR_READONLY(Sets.newHashSet(ADMINISTRATOR_READ)),
    MANAGER(Sets.newHashSet(MANAGER_READ,MANAGER_WRITE)),
    MANAGER_READONLY(Sets.newHashSet(MANAGER_READ)),
    EMPLOYEE(Sets.newHashSet(EMPLOYEE_READ,EMPLOYEE_WRITE)),
    EMPLOYEE_READONLY(Sets.newHashSet(EMPLOYEE_READ)),
    CUSTOMER(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE)),
    CUSTOMER_READONLY(Sets.newHashSet(CUSTOMER_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
