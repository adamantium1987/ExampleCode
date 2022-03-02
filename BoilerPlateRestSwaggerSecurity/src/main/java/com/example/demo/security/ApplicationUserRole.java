package com.example.demo.security;

import com.google.common.collect.Sets;
import java.util.Set;

public enum ApplicationUserRole {
    ADMINISTRATOR(Sets.newHashSet()),
    MANAGER(Sets.newHashSet()),
    EMPLOYEE(Sets.newHashSet()),
    CUSTOMER(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
